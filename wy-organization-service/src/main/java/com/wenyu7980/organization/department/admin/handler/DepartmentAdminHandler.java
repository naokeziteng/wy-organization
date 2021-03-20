package com.wenyu7980.organization.department.admin.handler;

import com.wenyu7980.organization.department.admin.domain.DepartmentAdminAdd;
import com.wenyu7980.organization.department.admin.domain.DepartmentAdminModify;
import com.wenyu7980.organization.department.domain.Department;

/**
 *
 * @author wenyu
 */
public interface DepartmentAdminHandler {
    /**
     * 创建
     * @param department
     * @return
     */
    Department add(DepartmentAdminAdd department);

    /**
     * 修改
     * @param id
     * @param department
     * @return
     */
    Department modify(String id, DepartmentAdminModify department);

    /**
     * 删除
     * @param id
     */
    void delete(String id);
}
