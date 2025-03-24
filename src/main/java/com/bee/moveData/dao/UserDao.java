package com.bee.moveData.dao;

import com.bee.moveData.entity.UserEntity;
import com.bee.moveData.model.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {
    List<UserEntity> getAllUser();
}
