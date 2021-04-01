package com.wenyu7980.organization.user.management.handler.impl;

import com.wenyu7980.data.jpa.query.AbstractQueryHandler;
import com.wenyu7980.organization.aggregation.UserAggregation;
import com.wenyu7980.organization.user.management.domain.UserManagementDetail;
import com.wenyu7980.organization.user.management.domain.UserManagementListDetail;
import com.wenyu7980.organization.user.management.domain.UserManagementPageDetail;
import com.wenyu7980.organization.user.management.handler.UserManagementQueryHandler;
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
public class UserManagementQueryHandlerImpl
  extends AbstractQueryHandler<UserEntity, UserManagementListDetail, UserManagementPageDetail> implements
  UserManagementQueryHandler {

    @Autowired
    private UserService userService;

    @Override
    public UserManagementDetail getById(String id) {
        UserEntity entity = userService.findById(id);
        UserManagementDetail user = new UserManagementDetail();
        UserConvert.convert(entity, user);
        user.setCreatedDateTime(entity.getCreatedDateTime());
        user.setUpdatedDateTime(entity.getUpdatedDateTime());
        user.setCreatedUser(UserAggregation.of(entity.getCreatedUserId()));
        user.setUpdatedUser(UserAggregation.of(entity.getUpdatedUserId()));
        return user;
    }

    @Override
    public UserManagementListDetail convertList(UserEntity entity) {
        UserManagementListDetail detail = new UserManagementListDetail();
        UserConvert.convert(entity, detail);
        return detail;
    }

    @Override
    public UserManagementPageDetail convertPage(UserEntity entity) {
        UserManagementPageDetail detail = new UserManagementPageDetail();
        UserConvert.convert(entity, detail);
        detail.setCreatedDateTime(entity.getCreatedDateTime());
        detail.setUpdatedDateTime(entity.getUpdatedDateTime());
        detail.setCreatedUser(UserAggregation.of(entity.getCreatedUserId()));
        detail.setUpdatedUser(UserAggregation.of(entity.getUpdatedUserId()));
        return detail;
    }

}
