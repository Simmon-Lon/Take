package com.Simmon.repository;

import com.Simmon.entity.Type;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TypeRepository {
    public Type findById(long id);
    public List<Type> findAll();
}
