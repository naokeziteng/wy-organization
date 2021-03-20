package com.wenyu7980.organization.user.service.impl;

import com.wenyu7980.data.jpa.query.AbstractQueryService;
import com.wenyu7980.organization.user.entity.UserEntity;
import com.wenyu7980.organization.user.service.UserQueryService;
import org.springframework.stereotype.Service;

/**
 *
 * @author wenyu
 */
@Service
public class UserQueryServiceImpl extends AbstractQueryService<UserEntity> implements UserQueryService {
}
