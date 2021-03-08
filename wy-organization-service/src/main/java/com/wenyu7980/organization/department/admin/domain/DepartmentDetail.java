package com.wenyu7980.organization.department.admin.domain;

import com.wenyu7980.aggregation.annotation.Aggregation;
import com.wenyu7980.aggregation.annotation.AggregationParam;
import com.wenyu7980.organization.aggregation.UserAggregation;
import com.wenyu7980.organization.department.domain.Department;

import java.util.List;

/**
 *
 * @author wenyu
 */
public class DepartmentDetail extends Department {
    private UserAggregation admin;
    @Aggregation(params = { @AggregationParam(name = "departmentId", value = "id") })
    private List<UserAggregation> members;

    public UserAggregation getAdmin() {
        return admin;
    }

    public void setAdmin(UserAggregation admin) {
        this.admin = admin;
    }

    public List<UserAggregation> getMembers() {
        return members;
    }

    public void setMembers(List<UserAggregation> members) {
        this.members = members;
    }
}
