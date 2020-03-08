package com.example.demo.repo;


import com.example.demo.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Serializable> {
    UserEntity findByUsername(String username);
}
