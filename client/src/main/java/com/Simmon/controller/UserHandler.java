package com.Simmon.controller;

import com.Simmon.entity.User;
import com.Simmon.entity.UserVO;
import com.Simmon.fegin.UserFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserHandler {

    @Autowired
    private UserFegin userFegin;

    @GetMapping("/findAll")
    @ResponseBody
    public UserVO findAll(@RequestParam("page") int page, @RequestParam("limit") int limit){
        int index=(page-1)*limit;
        UserVO userVO=new UserVO();
        userVO.setCode(0);
        userVO.setMsg("");
        userVO.setCount(userFegin.count());
        userVO.setData(userFegin.findAll(index,limit));
        return userVO;
    }

    @GetMapping("/redirect/{location}")
    public String redirect(@PathVariable("location") String location){
        return location;
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") long id){
        return userFegin.findById(id);
    }

    @GetMapping("/count")
    public int count(){
        return userFegin.count();
    }

    @PostMapping("/save")
    public String save(User user){
        user.setRegisterdate(new Date());
        userFegin.save(user);
        return "redirect:/user/redirect/user_manage";
    }

    @GetMapping("deleteById/{id}")
    public String deleteById(@PathVariable("id") long id){
        userFegin.deleteById(id);
        return "redirect:/user/redirect/user_manage";
    }
}
