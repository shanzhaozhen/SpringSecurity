package org.shanzhaozhen.springsecurity.admin.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @RequestMapping("/index")
    public String index(Model model) {
        return "admin/index/adminIndex";
    }

    @RequestMapping("/index2")
    public String index2(Model model) {
        return "admin/starter";
    }

    @RequestMapping("/menu")
    @ResponseBody
    public UserDetails menu() {
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userDetails;
    }




}
