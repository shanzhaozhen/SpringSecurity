package org.shanzhaozhen.springsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shanzhaozhen.springsecurity.admin.repository.SysPermissionRepository;
import org.shanzhaozhen.springsecurity.admin.repository.SysUserRepository;
import org.shanzhaozhen.springsecurity.bean.SysPermission;
import org.shanzhaozhen.springsecurity.utils.ComparatorUtils;
import org.shanzhaozhen.springsecurity.utils.NullUtils;
import org.shanzhaozhen.springsecurity.utils.UserDetailsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringsecurityApplicationTests {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void jpaTest() {
//        SysUser sysUser = new SysUser();
//        sysUser.setUsername("abcd");
//        sysUser.setPassword("123");
//        SysUser test = sysUserRepository.save(sysUser);
//
//        test.getUsername();

        List<SysPermission> sysPermissions = null;
        sysPermissions = sysPermissionRepository.findByUsername("abcd");
        NullUtils.clearNull(sysPermissions);
        System.out.println(sysPermissions.get(1).toString());

    }

    @Test
    public void dateTest() throws ParseException {
        String minDate = "2017-09-01";
        String maxDate = "2018-11-21";
        ArrayList<String> result = new ArrayList<String>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");//格式化为年月

        Calendar min = Calendar.getInstance();
        Calendar max = Calendar.getInstance();

        min.setTime(sdf.parse(minDate));
        min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

        max.setTime(sdf.parse(maxDate));
        max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

        Calendar curr = min;
        while (curr.before(max)) {
            result.add(sdf.format(curr.getTime()));
            curr.add(Calendar.MONTH, 1);
        }

        for (String a : result) {
            System.out.println(a);
        }

    }

    @Test
    public void menusTest() {
        //List<String> actions = UserDetailsUtils.getActionsByLoginUser();
        List<SysPermission> allMenus = this.sysPermissionRepository.findAll();

        List<SysPermission> rootMenus = new ArrayList<SysPermission>();
        Map<Integer, SysPermission> maps = new IdentityHashMap<Integer, SysPermission>();
        for(SysPermission menu : allMenus) {
            if(menu.getPid() != null) {
                maps.put(menu.getPid(), menu);
            }
        }
        for (SysPermission menu : allMenus) {
            if(menu.getPid() == null) {
                rootMenus.add(menu);
            }
            List<SysPermission> children = new ArrayList<SysPermission>();
            for (Map.Entry<Integer, SysPermission> entry : maps.entrySet()) {
                if(menu.getId().equals(entry.getKey())){
                    children.add(entry.getValue());
                }
            }
            if(children.size() > 0) {
                subClass(maps, rootMenus, children);
                menu.setChildrens(children);
            }
        }
        List<SysPermission> filterHms = new ArrayList<SysPermission>();
        for (SysPermission menu : rootMenus) {
            //控制父级有权限才遍历
            if(menu.getChildrens().size() > 0) {
                filterHms.add(menu);
            }
        }
        Collections.sort(filterHms, new ComparatorUtils());
//        return JsonUtil.toString(filterHms);
    }

    /**
     * 递归查找子分类节点.
     */
    private List<SysPermission> subClass(Map<Integer, SysPermission> maps, List<SysPermission> rootMenus, List<SysPermission> children) {
        for(SysPermission child : children) {
            List<SysPermission> grandsons = new ArrayList<SysPermission>();
            for (Map.Entry<Integer, SysPermission> entry : maps.entrySet()) {
                if(child.getId().equals(entry.getKey())) {
                    grandsons.add(entry.getValue());
                }
            }
            if(grandsons.size() > 0) {
                subClass(maps, rootMenus, grandsons);
            }
            Collections.sort(children, new ComparatorUtils());
        }
        return rootMenus;
    }


}
