package com.wenyu7980.organization.department.admin.controller;

import com.wenyu7980.organization.department.admin.domain.DepartmentDetail;
import com.wenyu7980.organization.department.admin.domain.DepartmentListDetail;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 *
 * @author wenyu
 */
@Api(tags = "部门管理（管理端）")
@RestController
@RequestMapping("admin/departments")
public class DepartmentAdminController {

    @ApiOperation("部门列表查询（管理端）")
    @GetMapping("list")
    public List<DepartmentListDetail> getList() {
        return null;
    }

    @ApiOperation("部门查询（管理端）")
    @GetMapping("{id}")
    public DepartmentDetail getById(@PathVariable("id") String id) {
        return null;
    }
}
