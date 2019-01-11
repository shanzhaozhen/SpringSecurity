package org.shanzhaozhen.springsecurity.admin.service.impl;

import org.shanzhaozhen.springsecurity.admin.repository.SysPermissionRepository;
import org.shanzhaozhen.springsecurity.admin.service.SysPermissionService;
import org.shanzhaozhen.springsecurity.bean.SysPermission;
import org.shanzhaozhen.springsecurity.param.MenuChild;
import org.shanzhaozhen.springsecurity.param.MenuRoot;

import java.util.ArrayList;
import java.util.List;

public class SysPermissionServiceImpl implements SysPermissionService {

    private SysPermissionRepository sysPermissionRepository;


    @Override
    public void getSysPermissionByUserName() {
        return;
    }


    public void getMenu() {
        List<SysPermission> list = sysPermissionRepository.findAll();

        if (list == null) {
            return;
        }

        List<MenuRoot> menuList = new ArrayList<>();
        MenuRoot root = null;

        for (SysPermission sysPermission : list) {
            if (sysPermission.getPid() == null) {
                root = new MenuRoot();
                root.setId(sysPermission.getId());
                root.setName(sysPermission.getDescription());
                root.setUrl(sysPermission.getUrl());
                menuList.add(root);
            }
        }

        for (SysPermission sysPermission : list) {
            for (MenuRoot menuRoot : menuList) {
                if (sysPermission.getPid() == menuRoot.getId()) {
                    MenuChild menuChild = new MenuChild(sysPermission.getId(), sysPermission.getDescription(), sysPermission.getUrl());
                    List<MenuChild> childList = menuRoot.getMenuChildList();
                    childList.add(menuChild);
                    menuRoot.setMenuChildList(childList);
                }
            }
        }


    }

}
