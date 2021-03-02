package com.wenyu7980.organization.department.admin.domain;

import com.wenyu7980.bff.annotation.Aggregation;
import com.wenyu7980.bff.annotation.AggregationParam;
import com.wenyu7980.organization.aggregation.UserSimple;
import com.wenyu7980.organization.department.domain.Department;

import java.util.List;

/**
 *
 * @author wenyu
 */
public class DepartmentDetail extends Department {
    @Aggregation
    private UserSimple admin;
    @Aggregation(params = { @AggregationParam(name = "departmentId", value = "id") })
    private List<UserSimple> members;

    public UserSimple getAdmin() {
        return admin;
    }

    public void setAdmin(UserSimple admin) {
        this.admin = admin;
    }

    public List<UserSimple> getMembers() {
        return members;
    }

    public void setMembers(List<UserSimple> members) {
        this.members = members;
    }
}
