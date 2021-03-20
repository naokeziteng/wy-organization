package com.wenyu7980.organization.user.service.impl;

import com.wenyu7980.common.exceptions.code404.NotFoundException;
import com.wenyu7980.organization.user.entity.UserEntity;
import com.wenyu7980.organization.user.repository.UserRepo;
import com.wenyu7980.organization.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author wenyu
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Override
    public UserEntity findById(String id) {
        return userRepo.findById(id).orElseThrow(() -> new NotFoundException("用户{0}不存在", id));
    }

    @Override
    public UserEntity save(UserEntity entity) {
        return userRepo.save(entity);
    }
}
