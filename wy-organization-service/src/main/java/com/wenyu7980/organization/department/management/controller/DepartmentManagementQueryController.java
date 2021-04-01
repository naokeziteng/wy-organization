package com.wenyu7980.organization.department.management.controller;

import com.wenyu7980.data.jpa.query.PageBody;
import com.wenyu7980.organization.department.management.domain.DepartmentManagementDetail;
import com.wenyu7980.organization.department.management.domain.DepartmentManagementListDetail;
import com.wenyu7980.organization.department.management.domain.DepartmentManagementPageDetail;
import com.wenyu7980.organization.department.management.handler.DepartmentManagementQueryHandler;
import com.wenyu7980.query.QueryCompare;
import com.wenyu7980.query.QueryCondition;
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
@RequestMapping("management/departments")
public class DepartmentManagementQueryController {
    @Autowired
    private DepartmentManagementQueryHandler queryHandler;

    @ApiOperation("部门列表查询（管理端）")
    @GetMapping("list")
    public List<DepartmentManagementListDetail> getList() {
        return queryHandler.getList(QueryLogic.and(QueryCondition.of("deletedFlag", QueryCompare.EQ, false)));
    }

    @ApiOperation("部门列表查询（管理端）")
    @GetMapping()
    public PageBody<DepartmentManagementPageDetail> getPage(@ApiParam("页码") @RequestParam(defaultValue = "0") int page,
      @ApiParam("页大小") @RequestParam(defaultValue = "10") int size) {
        return queryHandler.getPage(QueryLogic.and(QueryCondition.of("deletedFlag", QueryCompare.EQ, false)),
          PageRequest.of(page, size, Sort.Direction.DESC, "createdDateTime"));
    }

    @ApiOperation("部门查询（管理端）")
    @GetMapping("{id}")
    public DepartmentManagementDetail getById(@PathVariable("id") String id) {
        return queryHandler.getById(id);
    }
}
