package com.wenyu7980.organization.user.service;

import com.wenyu7980.organization.user.entity.UserEntity;

/**
 *
 * @author wenyu
 */
public interface UserService {
    /**
     * 查询
     * @param id
     * @return
     */
    UserEntity findById(String id);

    /**
     * 保存
     * @param entity
     * @return
     */
    UserEntity save(UserEntity entity);
}
