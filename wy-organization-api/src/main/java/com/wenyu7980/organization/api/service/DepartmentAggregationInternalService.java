package com.wenyu7980.organization.api.service;

import com.wenyu7980.organization.aggregation.DepartmentAggregation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-organization", path = "internal/aggregation/departments", contextId = "wy-organization-aggregation-department")
public interface DepartmentAggregationInternalService {
    /**
     * 数据聚合用用户
     * @param id
     * @return
     */
    @GetMapping("{id}")
    DepartmentAggregation getOne(@PathVariable("id") String id);
}
