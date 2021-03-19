package com.wenyu7980.organization.user.internal.controller;

import com.wenyu7980.organization.api.domain.UserInternal;
import com.wenyu7980.organization.api.service.UserInternalService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author wenyu
 */
@ApiIgnore
@RestController
@RequestMapping("internal/users")
public class UserInternalController implements UserInternalService {
    @Override
    public UserInternal getOne(String id) {
        return null;
    }
}
