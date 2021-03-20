package com.wenyu7980.organization.department.service;

import com.wenyu7980.organization.department.entity.DepartmentEntity;

/**
 *
 * @author wenyu
 */
public interface DepartmentService {
    /**
     * 查询
     * @param id
     * @return
     */
    DepartmentEntity findById(String id);

    /**
     * 保存
     * @param entity
     * @return
     */
    DepartmentEntity save(DepartmentEntity entity);
}
