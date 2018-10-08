package org.shanzhaozhen.springsecurity.controller;

import org.shanzhaozhen.springsecurity.bean.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

//    @GetMapping("/register")
//    public String index() {
//        return "public/register";
//    }

    @PostMapping("/register")
    public String register(SysUser sysUser) {

        return null;
    }

}
