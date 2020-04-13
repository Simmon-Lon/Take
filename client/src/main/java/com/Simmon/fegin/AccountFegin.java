package com.Simmon.fegin;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "account")
public interface AccountFegin {
    @GetMapping("/account/login/{username}/{password}/{type}")
    public Object login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("type") String type);
}
