package com.wenyu7980.organization.department.management.controller;

import com.wenyu7980.organization.department.management.domain.DepartmentManagementAdd;
import com.wenyu7980.organization.department.management.domain.DepartmentManagementModify;
import com.wenyu7980.organization.department.management.handler.DepartmentManagementHandler;
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
@RequestMapping("management/departments")
public class DepartmentManagementController {
    @Autowired
    private DepartmentManagementHandler departmentManagementHandler;

    @ApiOperation("创建")
    @PostMapping
    public Department add(@RequestBody @Valid DepartmentManagementAdd department) {
        return departmentManagementHandler.add(department);
    }

    @ApiOperation("修改")
    @PutMapping("{id}")
    public Department modify(@PathVariable String id, @RequestBody @Valid DepartmentManagementModify department) {
        return departmentManagementHandler.modify(id, department);
    }

    @ApiOperation("删除")
    @DeleteMapping("{id}")
    public void delete(@PathVariable String id) {
        departmentManagementHandler.delete(id);
    }

}
