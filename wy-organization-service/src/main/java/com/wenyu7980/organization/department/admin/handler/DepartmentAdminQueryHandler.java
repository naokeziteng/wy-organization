package com.wenyu7980.organization.department.admin.handler;

import com.wenyu7980.data.jpa.query.QueryExistsHandler;
import com.wenyu7980.data.jpa.query.QueryListHandler;
import com.wenyu7980.data.jpa.query.QueryPageHandler;
import com.wenyu7980.organization.department.admin.domain.DepartmentAdminDetail;
import com.wenyu7980.organization.department.admin.domain.DepartmentAdminListDetail;
import com.wenyu7980.organization.department.admin.domain.DepartmentAdminPageDetail;

/**
 *
 * @author wenyu
 */
public interface DepartmentAdminQueryHandler
  extends QueryListHandler<DepartmentAdminListDetail>, QueryPageHandler<DepartmentAdminPageDetail>, QueryExistsHandler {
    /**
     * 查询
     * @param id
     * @return
     */
    DepartmentAdminDetail getById(String id);

}
