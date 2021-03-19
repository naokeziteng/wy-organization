package com.wenyu7980.organization.api.service;

import com.wenyu7980.organization.aggregation.UserAggregation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-organization", path = "internal/aggregation/users", contextId = "wy-organization-aggregation-user")
public interface UserAggregationInternalService {
    /**
     * 数据聚合用用户
     * @param id
     * @return
     */
    @GetMapping("{id}")
    UserAggregation getOne(@PathVariable("id") String id);

    /**
     * 数据聚合用用户列表
     * @param departmentId
     * @return
     */
    @GetMapping()
    List<UserAggregation> getList(@RequestParam(required = false) String departmentId);
}
