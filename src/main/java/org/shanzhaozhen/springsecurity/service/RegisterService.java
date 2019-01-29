package org.shanzhaozhen.springsecurity.service;

import org.shanzhaozhen.springsecurity.bean.SysUser;

import java.util.Map;

public interface RegisterService {

    Map<String, Object> RegisterNewUser(SysUser sysUser);

    Map<String, Boolean> checkUsername(String username);

}
