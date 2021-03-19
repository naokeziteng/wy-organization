package com.wenyu7980.organization.department.internal.controller;

import com.wenyu7980.organization.aggregation.DepartmentAggregation;
import com.wenyu7980.organization.api.service.DepartmentAggregationInternalService;
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
@RequestMapping("internal/aggregation/departments")
public class DepartmentAggregationInternalController implements DepartmentAggregationInternalService {
    @Override
    @GetMapping("{id}")
    public DepartmentAggregation getOne(@PathVariable("id") String id) {
        return null;
    }
}
