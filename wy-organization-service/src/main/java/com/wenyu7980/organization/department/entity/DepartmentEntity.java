package com.wenyu7980.organization.department.entity;

import com.wenyu7980.organization.department.admin.domain.DepartmentAdminModify;
import com.wenyu7980.organization.user.entity.UserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author wenyu
 */
@Entity
@Table(name = "org_department")
public class DepartmentEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid32")
    private String id;
    /** 名称 */
    private String name;
    /** 上级部门 */
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private DepartmentEntity parent;
    /** 下级部门 */
    @OneToMany(mappedBy = "parent")
    private List<DepartmentEntity> departments;
    /** 部门领导 */
    @ManyToOne
    @JoinColumn(name = "leader_id")
    private UserEntity leader;
    /** 分管领导 */
    @ManyToMany
    @JoinTable(name = "org_department_assistant_leader", joinColumns = {
      @JoinColumn(name = "department_id")
    }, inverseJoinColumns = { @JoinColumn(name = "assistant_leader_id") })
    private Set<UserEntity> assistantLeaders;
    /** 部门成员 */
    @OneToMany(mappedBy = "department")
    private Set<UserEntity> members;
    /** 是否删除 */
    private Boolean deletedFlag = false;
    @CreatedDate
    private LocalDateTime createdDateTime;
    @CreatedBy
    private String createdUserId;
    @LastModifiedDate
    private LocalDateTime updatedDateTime;
    @LastModifiedBy
    private String updatedUserId;

    protected DepartmentEntity() {
    }

    public DepartmentEntity(String name, @Nullable UserEntity leader, @Nullable DepartmentEntity parent) {
        this.name = name;
        this.leader = leader;
        this.parent = parent;
    }

    /**
     * 修改
     * @param name
     * @param leader
     * @param department
     */
    public void modify(String name, @Nullable UserEntity leader, @Nullable DepartmentAdminModify department) {
        this.name = name;
        this.leader = leader;
        this.parent = parent;
    }

    /**
     * 删除
     */
    public void delete() {
        this.leader = null;
        this.assistantLeaders.clear();
        this.deletedFlag = true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DepartmentEntity getParent() {
        return parent;
    }

    public List<DepartmentEntity> getDepartments() {
        return departments;
    }

    public UserEntity getLeader() {
        return leader;
    }

    public Set<UserEntity> getAssistantLeaders() {
        return assistantLeaders;
    }

    public Set<UserEntity> getMembers() {
        return members;
    }

    public LocalDateTime getCreatedDateTime() {
        return createdDateTime;
    }

    public String getCreatedUserId() {
        return createdUserId;
    }

    public LocalDateTime getUpdatedDateTime() {
        return updatedDateTime;
    }

    public String getUpdatedUserId() {
        return updatedUserId;
    }

    public Boolean getDeletedFlag() {
        return deletedFlag;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DepartmentEntity that = (DepartmentEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
