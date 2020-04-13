package com.Simmon.repository;

import com.Simmon.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {
    public User login(String username,String password);
}
