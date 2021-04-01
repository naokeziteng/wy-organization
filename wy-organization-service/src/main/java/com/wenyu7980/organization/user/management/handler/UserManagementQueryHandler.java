package com.wenyu7980.organization.user.management.handler;

import com.wenyu7980.data.jpa.query.QueryExistsHandler;
import com.wenyu7980.data.jpa.query.QueryListHandler;
import com.wenyu7980.data.jpa.query.QueryPageHandler;
import com.wenyu7980.organization.user.management.domain.UserManagementDetail;
import com.wenyu7980.organization.user.management.domain.UserManagementListDetail;
import com.wenyu7980.organization.user.management.domain.UserManagementPageDetail;

/**
 *
 * @author wenyu
 */
public interface UserManagementQueryHandler
  extends QueryListHandler<UserManagementListDetail>, QueryPageHandler<UserManagementPageDetail>, QueryExistsHandler {
    /**
     * 查询
     * @param id
     * @return
     */
    UserManagementDetail getById(String id);
}
