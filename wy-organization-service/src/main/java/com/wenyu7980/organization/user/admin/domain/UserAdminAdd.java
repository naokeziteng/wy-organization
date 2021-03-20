package com.wenyu7980.organization.user.admin.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 *
 * @author wenyu
 */
public class UserAdminAdd {
    @ApiModelProperty(value = "用户名", required = true)
    @NotEmpty
    @Size(max = 128)
    private String username;
    @ApiModelProperty(value = "姓名", required = true)
    @NotEmpty
    @Size(max = 128)
    private String name;
    @ApiModelProperty(value = "手机号", required = true)
    @NotEmpty
    @Size(max = 45)
    private String mobile;
    @ApiModelProperty(value = "密码", required = true)
    @NotEmpty
    @Size(max = 20)
    private String password;
    @ApiModelProperty(value = "邮箱")
    @Email
    private String email;
    @ApiModelProperty(value = "部门id")
    @NotEmpty
    private String departmentId;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }
}
