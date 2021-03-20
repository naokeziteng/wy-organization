package com.wenyu7980.organization.user.admin.handler;

import com.wenyu7980.data.jpa.query.QueryExistsHandler;
import com.wenyu7980.data.jpa.query.QueryListHandler;
import com.wenyu7980.data.jpa.query.QueryPageHandler;
import com.wenyu7980.organization.user.admin.domain.UserAdminDetail;
import com.wenyu7980.organization.user.admin.domain.UserAdminListDetail;
import com.wenyu7980.organization.user.admin.domain.UserAdminPageDetail;

/**
 *
 * @author wenyu
 */
public interface UserAdminQueryHandler
  extends QueryListHandler<UserAdminListDetail>, QueryPageHandler<UserAdminPageDetail>, QueryExistsHandler {
    /**
     * 查询
     * @param id
     * @return
     */
    UserAdminDetail getById(String id);
}
