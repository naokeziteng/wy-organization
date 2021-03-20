package com.wenyu7980.organization.department.admin.controller;

import com.wenyu7980.organization.department.admin.domain.DepartmentAdminAdd;
import com.wenyu7980.organization.department.admin.domain.DepartmentAdminModify;
import com.wenyu7980.organization.department.admin.handler.DepartmentAdminHandler;
import com.wenyu7980.organization.department.domain.Department;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 *
 * @author wenyu
 */
@Api(tags = "部门管理（管理端）")
@RestController
@RequestMapping("admin/departments")
public class DepartmentAdminController {
    @Autowired
    private DepartmentAdminHandler departmentAdminHandler;

    @ApiOperation("创建")
    @PostMapping
    public Department add(@RequestBody @Valid DepartmentAdminAdd department) {
        return departmentAdminHandler.add(department);
    }

    @ApiOperation("修改")
    @PutMapping("{id}")
    public Department modify(@PathVariable String id, @RequestBody @Valid DepartmentAdminModify department) {
        return departmentAdminHandler.modify(id, department);
    }

    @ApiOperation("删除")
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        departmentAdminHandler.delete(id);
    }

}
