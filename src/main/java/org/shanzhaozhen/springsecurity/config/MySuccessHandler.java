package org.shanzhaozhen.springsecurity.config;

import org.shanzhaozhen.springsecurity.admin.service.SysPermissionService;
import org.shanzhaozhen.springsecurity.bean.SysPermission;
import org.shanzhaozhen.springsecurity.bean.SysUser;
import org.shanzhaozhen.springsecurity.bean.SysUserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Component
public class MySuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private String defaultTargetUrl = "/admin/index";

    @Autowired
    private SysPermissionService sysPermissionService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws ServletException, IOException {
        List<SysPermission> menus = sysPermissionService.getMenu();
        SysUserInfo userInfo = ((SysUser) authentication.getPrincipal()).getSysUserInfo();
        HttpSession httpSession = request.getSession();
        httpSession.setAttribute("menuList", menus);
        httpSession.setAttribute("userInfo", userInfo);
        super.setDefaultTargetUrl(defaultTargetUrl);
        super.onAuthenticationSuccess(request, response, authentication);
    }
}
