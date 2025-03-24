package com.bee.moveData.repository;

import com.bee.moveData.entity.UserEntity;
import com.bee.moveData.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    @Query(value = "SELECT * FROM user ", nativeQuery = true)
    List<UserEntity> getAllUser();
}
