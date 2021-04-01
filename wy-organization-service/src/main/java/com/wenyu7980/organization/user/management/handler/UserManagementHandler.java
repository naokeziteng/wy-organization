package com.wenyu7980.organization.user.management.handler;

import com.wenyu7980.organization.user.management.domain.UserManagementAdd;
import com.wenyu7980.organization.user.domain.User;

/**
 *
 * @author wenyu
 */
public interface UserManagementHandler {
    /**
     * 添加
     * @param user
     * @return
     */
    User add(UserManagementAdd user);
}
