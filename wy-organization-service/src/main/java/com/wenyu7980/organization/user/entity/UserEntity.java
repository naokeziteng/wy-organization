package com.wenyu7980.organization.user.entity;

import com.wenyu7980.organization.department.entity.DepartmentEntity;
import org.hibernate.annotations.GenericGenerator;
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
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "uuid32")
    private String id;
    /** 姓名 */
    private String name;
    /** 手机号 */
    private String mobile;
    /** 用户名 */
    private String username;
    /** 电子邮箱 */
    private String email;
    /** 所属部门 */
    @ManyToOne
    @JoinColumn(name = "department_id")
    private DepartmentEntity department;
    /** 管理部门 */
    @OneToMany(mappedBy = "leader")
    private Set<DepartmentEntity> departments;
    /** 分管部门 */
    @ManyToMany(mappedBy = "managers")
    private Set<DepartmentEntity> manageDepartments;
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

    public UserEntity(String name, String mobile, String username, String email, DepartmentEntity department) {
        this.name = name;
        this.mobile = mobile;
        this.username = username;
        this.email = email;
        this.department = department;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public DepartmentEntity getDepartment() {
        return department;
    }

    public Set<DepartmentEntity> getDepartments() {
        return departments;
    }

    public Set<DepartmentEntity> getManageDepartments() {
        return manageDepartments;
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
