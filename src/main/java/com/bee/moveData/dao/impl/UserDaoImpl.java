package com.bee.moveData.dao.impl;

import com.bee.moveData.dao.UserDao;
import com.bee.moveData.entity.UserEntity;
import com.bee.moveData.model.User;
import com.bee.moveData.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserEntity> getAllUser() {
        return userRepository.getAllUser();
    }
}
