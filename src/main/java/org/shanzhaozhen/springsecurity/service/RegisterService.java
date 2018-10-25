package org.shanzhaozhen.springsecurity.service;

import org.shanzhaozhen.springsecurity.bean.SysUser;
import org.shanzhaozhen.springsecurity.param.JsonMessage;

import java.util.Map;

public interface RegisterService {

    public Map<String, Object> RegisterNewUser(SysUser sysUser);

    public Map<String, Boolean> checkUsername(String username);

}
