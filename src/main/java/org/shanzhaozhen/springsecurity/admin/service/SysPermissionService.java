package org.shanzhaozhen.springsecurity.admin.service;

import org.shanzhaozhen.springsecurity.bean.SysPermission;

import java.util.List;
import java.util.Map;

public interface SysPermissionService {

    List<SysPermission> getMenu();

    Map<String, Object> getAllMenu();

}
