package com.wenyu7980.organization.user.admin.handler;

import com.wenyu7980.organization.user.admin.domain.UserAdminAdd;
import com.wenyu7980.organization.user.domain.User;

/**
 *
 * @author wenyu
 */
public interface UserAdminHandler {
    /**
     * 添加
     * @param user
     * @return
     */
    User add(UserAdminAdd user);
}
