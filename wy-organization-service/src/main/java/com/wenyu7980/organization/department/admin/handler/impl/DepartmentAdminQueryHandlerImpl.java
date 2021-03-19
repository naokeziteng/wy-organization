package com.wenyu7980.organization.department.admin.handler.impl;

import com.wenyu7980.data.jpa.query.AbstractQueryHandler;
import com.wenyu7980.organization.department.admin.domain.DepartmentAdminDetail;
import com.wenyu7980.organization.department.admin.domain.DepartmentAdminListDetail;
import com.wenyu7980.organization.department.admin.domain.DepartmentAdminPageDetail;
import com.wenyu7980.organization.department.admin.handler.DepartmentAdminQueryHandler;
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
public class DepartmentAdminQueryHandlerImpl
  extends AbstractQueryHandler<DepartmentEntity, DepartmentAdminListDetail, DepartmentAdminPageDetail>
  implements DepartmentAdminQueryHandler {
    @Autowired
    private DepartmentService departmentService;

    @Override
    public DepartmentAdminDetail getById(String id) {
        DepartmentEntity entity = departmentService.findById(id);
        DepartmentAdminDetail detail = new DepartmentAdminDetail();
        DepartmentConvert.convert(entity, detail);
        return detail;
    }

    @Override
    public DepartmentAdminListDetail convertList(DepartmentEntity entity) {
        DepartmentAdminListDetail detail = new DepartmentAdminListDetail();
        DepartmentConvert.convert(entity, detail);
        return detail;
    }

    @Override
    public DepartmentAdminPageDetail convertPage(DepartmentEntity entity) {
        DepartmentAdminPageDetail detail = new DepartmentAdminPageDetail();
        DepartmentConvert.convert(entity, detail);
        return detail;
    }
}
