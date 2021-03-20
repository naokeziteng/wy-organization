package com.wenyu7980.organization.department.convert;

import com.wenyu7980.organization.department.domain.Department;
import com.wenyu7980.organization.department.entity.DepartmentEntity;

/**
 *
 * @author wenyu
 */
public class DepartmentConvert {
    private DepartmentConvert() {
    }

    public static void convert(DepartmentEntity entity, Department department) {
        department.setId(entity.getId());
        department.setName(entity.getName());
    }

    public static Department convert(DepartmentEntity entity) {
        Department department = new Department();
        convert(entity, department);
        return department;
    }
}
