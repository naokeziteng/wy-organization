package com.wenyu7980.organization.user.admin.controller;

import com.wenyu7980.data.jpa.query.PageBody;
import com.wenyu7980.organization.user.admin.domain.UserAdminDetail;
import com.wenyu7980.organization.user.admin.domain.UserAdminListDetail;
import com.wenyu7980.organization.user.admin.domain.UserAdminPageDetail;
import com.wenyu7980.organization.user.admin.handler.UserAdminQueryHandler;
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
@RequestMapping("admin/users")
public class UserAdminQueryController {
    @Autowired
    private UserAdminQueryHandler queryHandler;

    @ApiOperation("查询")
    @GetMapping("{id}")
    public UserAdminDetail getOne(@PathVariable String id) {
        return queryHandler.getById(id);
    }

    @ApiOperation("分页查询")
    @GetMapping
    public PageBody<UserAdminPageDetail> getPage(@ApiParam("页码") @RequestParam(defaultValue = "0") int page,
      @ApiParam("页大小") @RequestParam(defaultValue = "10") int size) {
        return queryHandler
          .getPage(QueryLogic.and(), PageRequest.of(page, size, Sort.Direction.DESC, "createdDateTime"));
    }

    @ApiOperation("列表查询")
    @GetMapping("list")
    public List<UserAdminListDetail> getList() {
        return queryHandler.getList(QueryLogic.and());
    }
}
