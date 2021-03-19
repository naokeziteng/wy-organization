package com.wenyu7980.organization.user.entity;

import com.wenyu7980.organization.department.entity.DepartmentEntity;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author wenyu
 */
@Entity
@Table(name = "org_user")
@EntityListeners(AuditingEntityListener.class)
public class UserEntity {
    @Id
    private String id;
    /** 姓名 */
    private String name;
    /** 所属部门 */
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;
    /** 管理部门 */
    @OneToMany(mappedBy = "leader")
    private Set<DepartmentEntity> departments;
    /** 分管部门 */
    @ManyToMany(mappedBy = "assistantLeaders")
    private Set<DepartmentEntity> assistantDepartments;
    @CreatedDate
    private LocalDateTime createdDateTime;
    @CreatedBy
    private String createdUserId;
    @LastModifiedDate
    private LocalDateTime updatedDateTime;
    @LastModifiedBy
    private String updatedUserId;

    protected UserEntity() {
    }

    public UserEntity(String name, DepartmentEntity department) {
        this.name = name;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public Set<DepartmentEntity> getDepartments() {
        return departments;
    }

    public Set<DepartmentEntity> getAssistantDepartments() {
        return assistantDepartments;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserEntity that = (UserEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
