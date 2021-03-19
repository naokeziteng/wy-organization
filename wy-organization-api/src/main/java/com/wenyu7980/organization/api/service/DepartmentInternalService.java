package com.wenyu7980.organization.api.service;

import com.wenyu7980.organization.api.domain.DepartmentInternal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-organization", path = "internal/departments", contextId = "wy-organization-department")
public interface DepartmentInternalService {
    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("id")
    DepartmentInternal getOne(@PathVariable("id") String id);
}
