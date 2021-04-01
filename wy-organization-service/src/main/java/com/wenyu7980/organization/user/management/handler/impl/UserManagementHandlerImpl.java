package com.wenyu7980.organization.user.management.handler.impl;

import com.wenyu7980.authentication.api.domain.UserInternalAdd;
import com.wenyu7980.authentication.api.service.UserAuthInternalService;
import com.wenyu7980.organization.department.entity.DepartmentEntity;
import com.wenyu7980.organization.department.service.DepartmentService;
import com.wenyu7980.organization.user.management.domain.UserManagementAdd;
import com.wenyu7980.organization.user.management.handler.UserManagementHandler;
import com.wenyu7980.organization.user.convert.UserConvert;
import com.wenyu7980.organization.user.domain.User;
import com.wenyu7980.organization.user.entity.UserEntity;
import com.wenyu7980.organization.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author wenyu
 */
@Component
public class UserManagementHandlerImpl implements UserManagementHandler {
    @Autowired
    private UserService userService;
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private UserAuthInternalService userAuthInternalService;

    @Override
    @Transactional(propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
    public User add(UserManagementAdd user) {
        DepartmentEntity department = departmentService.findById(user.getDepartmentId());
        UserEntity entity = new UserEntity(user.getName(), user.getMobile(), user.getUsername(), user.getEmail(),
          department);
        entity = userService.save(entity);
        userAuthInternalService
          .add(new UserInternalAdd(entity.getId(), user.getUsername(), user.getMobile(), user.getPassword()));
        return UserConvert.convert(entity);
    }
}
