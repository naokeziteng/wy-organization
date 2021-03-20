package com.wenyu7980.organization.user.convert;

import com.wenyu7980.organization.user.domain.User;
import com.wenyu7980.organization.user.entity.UserEntity;

/**
 *
 * @author wenyu
 */
public class UserConvert {
    private UserConvert() {
    }

    public static void convert(UserEntity entity, User user) {
        user.setId(entity.getId());
        user.setName(entity.getName());
    }

    public static User convert(UserEntity entity) {
        User user = new User();
        convert(entity, user);
        return user;
    }
}
