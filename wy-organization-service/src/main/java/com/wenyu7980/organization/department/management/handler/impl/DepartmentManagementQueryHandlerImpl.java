package com.wenyu7980.organization.department.management.handler.impl;

import com.wenyu7980.data.jpa.query.AbstractQueryHandler;
import com.wenyu7980.organization.department.management.domain.DepartmentManagementDetail;
import com.wenyu7980.organization.department.management.domain.DepartmentManagementListDetail;
import com.wenyu7980.organization.department.management.domain.DepartmentManagementPageDetail;
import com.wenyu7980.organization.department.management.handler.DepartmentManagementQueryHandler;
import com.wenyu7980.organization.department.convert.DepartmentConvert;
import com.wenyu7980.organization.department.entity.DepartmentEntity;
import com.wenyu7980.organization.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author wenyu
 */
@Component
public class DepartmentManagementQueryHandlerImpl
  extends AbstractQueryHandler<DepartmentEntity, DepartmentManagementListDetail, DepartmentManagementPageDetail>
  implements DepartmentManagementQueryHandler {
    @Autowired
    private DepartmentService departmentService;

    @Override
    public DepartmentManagementDetail getById(String id) {
        DepartmentEntity entity = departmentService.findById(id);
        DepartmentManagementDetail detail = new DepartmentManagementDetail();
        DepartmentConvert.convert(entity, detail);
        return detail;
    }

    @Override
    public DepartmentManagementListDetail convertList(DepartmentEntity entity) {
        DepartmentManagementListDetail detail = new DepartmentManagementListDetail();
        DepartmentConvert.convert(entity, detail);
        return detail;
    }

    @Override
    public DepartmentManagementPageDetail convertPage(DepartmentEntity entity) {
        DepartmentManagementPageDetail detail = new DepartmentManagementPageDetail();
        DepartmentConvert.convert(entity, detail);
        return detail;
    }
}
