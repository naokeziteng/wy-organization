package com.wenyu7980.organization.department.management.handler;

import com.wenyu7980.data.jpa.query.QueryExistsHandler;
import com.wenyu7980.data.jpa.query.QueryListHandler;
import com.wenyu7980.data.jpa.query.QueryPageHandler;
import com.wenyu7980.organization.department.management.domain.DepartmentManagementDetail;
import com.wenyu7980.organization.department.management.domain.DepartmentManagementListDetail;
import com.wenyu7980.organization.department.management.domain.DepartmentManagementPageDetail;

/**
 *
 * @author wenyu
 */
public interface DepartmentManagementQueryHandler
  extends QueryListHandler<DepartmentManagementListDetail>, QueryPageHandler<DepartmentManagementPageDetail>, QueryExistsHandler {
    /**
     * 查询
     * @param id
     * @return
     */
    DepartmentManagementDetail getById(String id);

}
