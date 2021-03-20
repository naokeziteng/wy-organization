package com.wenyu7980.organization.department.admin.domain;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;

/**
 *
 * @author wenyu
 */
public class DepartmentAdminModify {
    @ApiModelProperty(value = "", required = true)
    @NotEmpty
    private String name;
    @ApiModelProperty(value = "上级部门id")
    private String parentId;
    @ApiModelProperty(value = "领导id")
    private String leaderId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId;
    }
}
