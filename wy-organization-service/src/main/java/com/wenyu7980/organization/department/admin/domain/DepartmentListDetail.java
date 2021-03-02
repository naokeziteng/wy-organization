package com.wenyu7980.organization.department.admin.domain;

import com.wenyu7980.bff.annotation.Aggregation;
import com.wenyu7980.organization.aggregation.UserSimple;
import com.wenyu7980.organization.department.domain.Department;

/**
 *
 * @author wenyu
 */
public class DepartmentListDetail extends Department {
    @Aggregation
    private UserSimple admin;

    public UserSimple getAdmin() {
        return admin;
    }

    public void setAdmin(UserSimple admin) {
        this.admin = admin;
    }
}
