package com.wenyu7980.organization.user.domain;

import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author wenyu
 */
public class User {
    @ApiModelProperty(value = "id", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String id;
    @ApiModelProperty(value = "姓名", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
