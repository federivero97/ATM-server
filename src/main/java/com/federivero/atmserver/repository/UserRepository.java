package com.federivero.atmserver.repository;

import com.federivero.atmserver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity,Integer> {
    UserEntity findByUserName(String username);
}
