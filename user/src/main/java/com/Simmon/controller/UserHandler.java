package com.Simmon.controller;

import com.Simmon.entity.User;
import com.Simmon.repository.UserRepsoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserHandler {
    @Autowired
    private UserRepsoitory userRepsoitory;

    @GetMapping("/findAll/{index}/{limit}")
    public List<User> findAll(@PathVariable("index") int index,@PathVariable("limit") int limit){
        return userRepsoitory.findAll(index,limit);
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id){
        return userRepsoitory.findById(id);
    }

    @GetMapping("/count")
    public int count(){
        return userRepsoitory.count();
    }

    @PostMapping("/save")
    public void save(@RequestBody User user){
        userRepsoitory.save(user);
    }

    @PutMapping("/update")
    public void update(@RequestBody User user){
        userRepsoitory.update(user);
    }

    @DeleteMapping("deleteById/{id}")
    public void deleteById(@PathVariable("id") long id){
        userRepsoitory.deleteById(id);
    }
}
