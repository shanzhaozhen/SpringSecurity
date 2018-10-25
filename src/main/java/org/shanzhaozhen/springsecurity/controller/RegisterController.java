package org.shanzhaozhen.springsecurity.controller;

import org.shanzhaozhen.springsecurity.bean.SysUser;
import org.shanzhaozhen.springsecurity.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/register")
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping
    public String register() {
        return "public/register";
    }

    @PostMapping
    @ResponseBody
    public Map<String, Object> register(SysUser sysUser) {
        return registerService.RegisterNewUser(sysUser);
    }

    @PostMapping("/checkUsername")
    @ResponseBody
    public Map<String, Boolean> checkUserName(String username) {
        return registerService.checkUsername(username);
    }


}
