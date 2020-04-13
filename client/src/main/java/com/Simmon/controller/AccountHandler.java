package com.Simmon.controller;

import com.Simmon.entity.Admin;
import com.Simmon.entity.User;
import com.Simmon.fegin.AccountFegin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.LinkedHashMap;

@Controller
@RequestMapping("/account")
public class AccountHandler {

    @Autowired
    private AccountFegin accountFegin;

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("type") String type, HttpSession session){
        Object object=accountFegin.login(username,password,type);
        LinkedHashMap<String,Object> hashMap=(LinkedHashMap)object;
        String result=null;
        if(object==null){
            result="login";
        }else {
            switch (type){
                case "user":
                    User user=new User();
                    String idStr=hashMap.get("id")+"";
                    long id=Long.parseLong(idStr);
                    String nickname=(String)hashMap.get("nickname");
                    user.setId(id);
                    user.setNickname(nickname);
                    session.setAttribute("user",user);
                    result= "index";
                    break;
                case "admin":
                    Admin admin=(Admin) object;
                    session.setAttribute("admin",admin);
                    result="";
                    break;
            }
        }
        return result;
    }
}
