package com.wenyu7980.organization.department.admin.controller;

import com.wenyu7980.data.jpa.query.PageBody;
import com.wenyu7980.organization.department.admin.domain.DepartmentAdminDetail;
import com.wenyu7980.organization.department.admin.domain.DepartmentAdminListDetail;
import com.wenyu7980.organization.department.admin.domain.DepartmentAdminPageDetail;
import com.wenyu7980.organization.department.admin.handler.DepartmentAdminQueryHandler;
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
@Api(tags = "部门管理（管理端）")
@RestController
@RequestMapping("admin/departments")
public class DepartmentAdminQueryController {
    @Autowired
    private DepartmentAdminQueryHandler queryHandler;

    @ApiOperation("部门列表查询（管理端）")
    @GetMapping("list")
    public List<DepartmentAdminListDetail> getList() {
        return queryHandler.getList(QueryLogic.and());
    }

    @ApiOperation("部门列表查询（管理端）")
    @GetMapping()
    public PageBody<DepartmentAdminPageDetail> getPage(@ApiParam("页码") @RequestParam(defaultValue = "0") int page,
      @ApiParam("页大小") @RequestParam(defaultValue = "10") int size) {
        return queryHandler
          .getPage(QueryLogic.and(), PageRequest.of(page, size, Sort.Direction.DESC, "createdDateTime"));
    }

    @ApiOperation("部门查询（管理端）")
    @GetMapping("{id}")
    public DepartmentAdminDetail getById(@PathVariable("id") String id) {
        return queryHandler.getById(id);
    }
}
