package com.wenyu7980.organization.user.internal.controller;

import com.wenyu7980.aggregation.annotation.Aggregation;
import com.wenyu7980.organization.aggregation.UserAggregation;
import com.wenyu7980.organization.api.service.UserAggregationInternalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author wenyu
 */
@RestController
@RequestMapping("internal/aggregation/users")
public class UserAggregationInternalController implements UserAggregationInternalService {
    @Override
    @GetMapping("{id}")
    @Aggregation
    public UserAggregation getOne(@PathVariable("id") String id) {
        UserAggregation user = new UserAggregation();
        user.setId(id);
        user.setName("Tom" + id);
        return user;
    }

    @Override
    @GetMapping()
    @Aggregation
    public List<UserAggregation> getList(@RequestParam(required = false) String departmentId) {
        return null;
    }
}
