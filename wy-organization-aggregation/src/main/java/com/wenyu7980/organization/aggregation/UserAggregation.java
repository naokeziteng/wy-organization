package com.wenyu7980.organization.aggregation;

import com.wenyu7980.aggregation.annotation.Aggregation;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @author wenyu
 */
@Aggregation
public class UserAggregation {
    @ApiModelProperty(value = "id", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String id;
    @ApiModelProperty(value = "姓名", accessMode = ApiModelProperty.AccessMode.READ_ONLY)
    private String name;

    public UserAggregation() {
    }

    public UserAggregation(String id) {
        this.id = id;
    }

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
