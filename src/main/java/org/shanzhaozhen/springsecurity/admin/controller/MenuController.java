package org.shanzhaozhen.springsecurity.admin.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.shanzhaozhen.springsecurity.admin.service.SysPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
@RequestMapping("/admin")
public class MenuController {

    @Autowired
    private SysPermissionService sysPermissionService;

    @GetMapping("/menu")
    public String index() {
        return "admin/menu/menu";
    }

    @GetMapping("/menus")
    @ResponseBody
    public Map<String, Object> datas() {
        return sysPermissionService.getAllMenu();
    }

}
