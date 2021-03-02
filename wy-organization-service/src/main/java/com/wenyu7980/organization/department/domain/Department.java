package com.wenyu7980.organization.department.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author wenyu
 */
public class Department {
    @ApiModelProperty(value = "", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
