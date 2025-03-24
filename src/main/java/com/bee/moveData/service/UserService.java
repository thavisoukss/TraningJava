package com.bee.moveData.service;

import com.bee.moveData.dao.UserDao;
import com.bee.moveData.dao.impl.UserDaoImpl;
import com.bee.moveData.entity.UserEntity;
import com.bee.moveData.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public List<User> getAllUser(){
        List<User> result = new ArrayList<>();
        List<UserEntity> getAlluser = userDao.getAllUser();

        for(UserEntity userEntity : getAlluser){
            User user = User.builder()
                    .id(userEntity.getId())
                    .email(userEntity.getEmail().equals("dd") ? "rr" : userEntity.getEmail())
                    .password(userEntity.getPassword())
                    .username(userEntity.getUsername())
                    .createdAt(userEntity.getCreatedAt())
                    .build();
              result.add(user);
        }
        return result;

    }



}
