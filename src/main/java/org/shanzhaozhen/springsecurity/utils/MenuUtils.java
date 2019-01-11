package org.shanzhaozhen.springsecurity.utils;

import org.shanzhaozhen.springsecurity.admin.repository.SysPermissionRepository;
import org.shanzhaozhen.springsecurity.bean.SysPermission;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class MenuUtils {

//    @Autowired
//    private SysPermissionRepository sysPermissionRepository;
//
//    public List<SysPermission> getMenuTree(List<SysPermission> allList) {
//        List<String> actions = UserDetailsUtils.getActionsByLoginUser();
//        //所有权限
//        List<SysPermission> allMenu = this.sysPermissionRepository.findAll();
//        //根节点
//        List<SysPermission> rootMenu = new ArrayList<SysPermission>();
//        Map<String, SysPermission> maps = new IdentityHashMap<String, SysPermission>();
//
//        for (SysPermission sysPermission : allMenu) {
//            if(sysPermission.getPid() == null) {
//                rootMenu.add(sysPermission);
//            }
//            List<SysPermission> children = new ArrayList<SysPermission>();
//            for (Entry<String, SysPermission> entry : maps.entrySet()) {
//                if( space.getCdid().equals( entry.getKey() ) ){
//                    children.add(entry.getValue());
//                }
//            }
//            if(children.size() > 0) {
//                subClass(maps, hms, children);
//                space.setChildren(children);
//            }
//        }
//        List<SysPermission> filterHms = new ArrayList<SysPermission>();
//        for (SysPermission tSysCd : hms) {
//            if(NullUtils.isEmpty(cdid)) {
//                //控制父级有权限才遍历
//                if(tSysCd.getChildren().size() > 0 || actions.indexOf(tSysCd.getAction()) > -1)
//                    filterHms.add(tSysCd);
//            }else {
//                if(tSysCd.getCdid().equals(cdid)) filterHms.add(tSysCd);
//            }
//        }
//        Collections.sort(filterHms, new TSysCdComparator());
//        return JsonUtil.toString(filterHms);
//        return null;
//    }

//    public static List<MenuChild> getMenu(List<SysPermission> allList) {
//
//        List<MenuRoot> menuList = new ArrayList<>();
//        MenuRoot root = null;
//
//        for (SysPermission sysPermission : allList) {
//            if (sysPermission.getPid() == null) {
//                root = new MenuRoot();
//                root.setId(sysPermission.getId());
//                root.setName(sysPermission.getDescription());
//                root.setUrl(sysPermission.getUrl());
//                menuList.add(root);
//            }
//        }
//
//        for (SysPermission sysPermission : allList) {
//            for (MenuRoot menuRoot : menuList) {
//                if (sysPermission.getPid() == menuRoot.getId()) {
//                    MenuChild menuChild = new MenuChild(sysPermission.getId(), sysPermission.getDescription(), sysPermission.getUrl());
//                    List<MenuChild> childList = menuRoot.getMenuChildList();
//                    childList.add(menuChild);
//                    menuRoot.setMenuChildList(childList);
//                }
//            }
//        }
//
//
//        return null;
//    }

}
