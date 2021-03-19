package com.wenyu7980.organization.department.internal.controller;

import com.wenyu7980.organization.api.domain.DepartmentInternal;
import com.wenyu7980.organization.api.service.DepartmentInternalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author wenyu
 */
@ApiIgnore
@RestController
@RequestMapping("internal/departments")
public class DepartmentInternalController implements DepartmentInternalService {
    @Override
    @GetMapping("{id}")
    public DepartmentInternal getOne(@PathVariable("id") String id) {
        return null;
    }
}
