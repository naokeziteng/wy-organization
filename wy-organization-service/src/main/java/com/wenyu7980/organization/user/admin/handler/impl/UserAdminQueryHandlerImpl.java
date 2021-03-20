package com.wenyu7980.organization.user.admin.handler.impl;

import com.wenyu7980.data.jpa.query.AbstractQueryHandler;
import com.wenyu7980.organization.aggregation.UserAggregation;
import com.wenyu7980.organization.user.admin.domain.UserAdminDetail;
import com.wenyu7980.organization.user.admin.domain.UserAdminListDetail;
import com.wenyu7980.organization.user.admin.domain.UserAdminPageDetail;
import com.wenyu7980.organization.user.admin.handler.UserAdminQueryHandler;
import com.wenyu7980.organization.user.convert.UserConvert;
import com.wenyu7980.organization.user.entity.UserEntity;
import com.wenyu7980.organization.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author wenyu
 */
@Component
public class UserAdminQueryHandlerImpl
  extends AbstractQueryHandler<UserEntity, UserAdminListDetail, UserAdminPageDetail> implements UserAdminQueryHandler {

    @Autowired
    private UserService userService;

    @Override
    public UserAdminDetail getById(String id) {
        UserEntity entity = userService.findById(id);
        UserAdminDetail user = new UserAdminDetail();
        UserConvert.convert(entity, user);
        user.setCreatedDateTime(entity.getCreatedDateTime());
        user.setUpdatedDateTime(entity.getUpdatedDateTime());
        user.setCreatedUser(UserAggregation.of(entity.getCreatedUserId()));
        user.setUpdatedUser(UserAggregation.of(entity.getUpdatedUserId()));
        return user;
    }

    @Override
    public UserAdminListDetail convertList(UserEntity entity) {
        UserAdminListDetail detail = new UserAdminListDetail();
        UserConvert.convert(entity, detail);
        return detail;
    }

    @Override
    public UserAdminPageDetail convertPage(UserEntity entity) {
        UserAdminPageDetail detail = new UserAdminPageDetail();
        UserConvert.convert(entity, detail);
        detail.setCreatedDateTime(entity.getCreatedDateTime());
        detail.setUpdatedDateTime(entity.getUpdatedDateTime());
        detail.setCreatedUser(UserAggregation.of(entity.getCreatedUserId()));
        detail.setUpdatedUser(UserAggregation.of(entity.getUpdatedUserId()));
        return detail;
    }

}
