package com.wenyu7980.organization.user.internal.controller;

import com.wenyu7980.bff.annotation.Aggregation;
import com.wenyu7980.organization.aggregation.UserSimple;
import com.wenyu7980.organization.api.service.UserInternalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 *
 * @author wenyu
 */
@RestController
@RequestMapping("internal/aggregation/users")
public class UserInternalController implements UserInternalService {
    @Override
    @GetMapping("{id}")
    @Aggregation
    public UserSimple getOne(@PathVariable("id") String id) {
        return null;
    }

    @Override
    @GetMapping()
    @Aggregation
    public List<UserSimple> getList(@RequestParam(required = false) String departmentId) {
        return null;
    }
}
