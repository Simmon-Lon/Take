package com.Simmon.repository;

import com.Simmon.entity.Admin;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
public interface AdminRepository {
    public Admin login(String username,String password);
}
