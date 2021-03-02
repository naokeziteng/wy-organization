package com.wenyu7980.organization.department.admin.domain;

import com.wenyu7980.aggregation.annotation.Aggregation;
import com.wenyu7980.organization.aggregation.UserAggregation;
import com.wenyu7980.organization.department.domain.Department;

/**
 *
 * @author wenyu
 */
public class DepartmentListDetail extends Department {
    @Aggregation
    private UserAggregation admin;

    public UserAggregation getAdmin() {
        return admin;
    }

    public void setAdmin(UserAggregation admin) {
        this.admin = admin;
    }
}
