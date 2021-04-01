package com.wenyu7980.organization.department.management.handler;

import com.wenyu7980.organization.department.management.domain.DepartmentManagementAdd;
import com.wenyu7980.organization.department.management.domain.DepartmentManagementModify;
import com.wenyu7980.organization.department.domain.Department;

/**
 *
 * @author wenyu
 */
public interface DepartmentManagementHandler {
    /**
     * 创建
     * @param department
     * @return
     */
    Department add(DepartmentManagementAdd department);

    /**
     * 修改
     * @param id
     * @param department
     * @return
     */
    Department modify(String id, DepartmentManagementModify department);

    /**
     * 删除
     * @param id
     */
    void delete(String id);
}
