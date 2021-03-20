package com.wenyu7980.organization.department.service.impl;

import com.wenyu7980.common.exceptions.code404.NotFoundException;
import com.wenyu7980.organization.department.entity.DepartmentEntity;
import com.wenyu7980.organization.department.repository.DepartmentRepo;
import com.wenyu7980.organization.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wenyu
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepo departmentRepo;

    @Override
    public DepartmentEntity findById(String id) {
        return departmentRepo.findById(id).orElseThrow(() -> new NotFoundException("部门{0}不存在", id));
    }

    @Override
    public DepartmentEntity save(DepartmentEntity entity) {
        return departmentRepo.save(entity);
    }
}
