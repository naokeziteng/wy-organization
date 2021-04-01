package com.wenyu7980.organization.user.management.controller;

import com.wenyu7980.data.jpa.query.PageBody;
import com.wenyu7980.organization.user.management.domain.UserManagementDetail;
import com.wenyu7980.organization.user.management.domain.UserManagementListDetail;
import com.wenyu7980.organization.user.management.domain.UserManagementPageDetail;
import com.wenyu7980.organization.user.management.handler.UserManagementQueryHandler;
import com.wenyu7980.query.QueryLogic;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author wenyu
 */
@Api(tags = "用户管理（管理端）")
@RestController
@RequestMapping("management/users")
public class UserManagementQueryController {
    @Autowired
    private UserManagementQueryHandler queryHandler;

    @ApiOperation("查询")
    @GetMapping("{id}")
    public UserManagementDetail getOne(@PathVariable String id) {
        return queryHandler.getById(id);
    }

    @ApiOperation("分页查询")
    @GetMapping
    public PageBody<UserManagementPageDetail> getPage(@ApiParam("页码") @RequestParam(defaultValue = "0") int page,
      @ApiParam("页大小") @RequestParam(defaultValue = "10") int size) {
        return queryHandler
          .getPage(QueryLogic.and(), PageRequest.of(page, size, Sort.Direction.DESC, "createdDateTime"));
    }

    @ApiOperation("列表查询")
    @GetMapping("list")
    public List<UserManagementListDetail> getList() {
        return queryHandler.getList(QueryLogic.and());
    }
}
