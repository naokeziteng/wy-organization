package com.wenyu7980.organization.user.management.controller;

import com.wenyu7980.organization.user.management.domain.UserManagementAdd;
import com.wenyu7980.organization.user.management.handler.UserManagementHandler;
import com.wenyu7980.organization.user.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 *
 * @author wenyu
 */
@Api(tags = "用户管理（管理端）")
@RestController
@RequestMapping("management/users")
public class UserManagementController {
    @Autowired
    private UserManagementHandler userManagementHandler;

    @ApiOperation("创建")
    @PostMapping
    public User add(@RequestBody @Valid UserManagementAdd user) {
        return userManagementHandler.add(user);
    }
}
