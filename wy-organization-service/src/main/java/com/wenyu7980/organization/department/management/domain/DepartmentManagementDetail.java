package com.wenyu7980.organization.department.management.domain;

import com.wenyu7980.aggregation.annotation.Aggregation;
import com.wenyu7980.aggregation.annotation.AggregationParam;
import com.wenyu7980.organization.aggregation.UserAggregation;
import com.wenyu7980.organization.department.domain.Department;

import java.util.List;

/**
 *
 * @author wenyu
 */
public class DepartmentManagementDetail extends Department {
    private UserAggregation leader;
    @Aggregation(params = { @AggregationParam(name = "departmentId", value = "id") })
    private List<UserAggregation> members;

    public UserAggregation getLeader() {
        return leader;
    }

    public void setLeader(UserAggregation leader) {
        this.leader = leader;
    }

    public List<UserAggregation> getMembers() {
        return members;
    }

    public void setMembers(List<UserAggregation> members) {
        this.members = members;
    }
}
