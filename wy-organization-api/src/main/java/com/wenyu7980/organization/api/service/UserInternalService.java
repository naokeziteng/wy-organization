package com.wenyu7980.organization.api.service;

import com.wenyu7980.organization.aggregation.UserSimple;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-organization", path = "internal/aggregation/users", contextId = "wy-organization-user")
public interface UserInternalService {
    /**
     * 数据聚合用用户
     * @param id
     * @return
     */
    @GetMapping("{id}")
    UserSimple getOne(@PathVariable("id") String id);

    /**
     * 数据聚合用用户列表
     * @param departmentId
     * @return
     */
    @GetMapping()
    List<UserSimple> getList(@RequestParam(required = false) String departmentId);
}
