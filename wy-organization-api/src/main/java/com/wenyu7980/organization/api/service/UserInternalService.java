package com.wenyu7980.organization.api.service;

import com.wenyu7980.organization.api.domain.UserInternal;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author wenyu
 */
@FeignClient(name = "wy-organization", path = "internal/users", contextId = "wy-organization-user")
public interface UserInternalService {
    /**
     * 查询
     * @param id
     * @return
     */
    @GetMapping("{id}")
    UserInternal getOne(@PathVariable("id") String id);
}
