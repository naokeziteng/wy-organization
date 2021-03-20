package com.wenyu7980.organization.user.admin.controller;

import com.wenyu7980.organization.user.admin.domain.UserAdminAdd;
import com.wenyu7980.organization.user.admin.handler.UserAdminHandler;
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
@RequestMapping("admin/users")
public class UserAdminController {
    @Autowired
    private UserAdminHandler userAdminHandler;

    @ApiOperation("创建")
    @PostMapping
    public User add(@RequestBody @Valid UserAdminAdd user) {
        return userAdminHandler.add(user);
    }
}
