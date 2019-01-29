package org.shanzhaozhen.springsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shanzhaozhen.springsecurity.admin.repository.SysPermissionRepository;
import org.shanzhaozhen.springsecurity.admin.repository.SysUserInfoRepository;
import org.shanzhaozhen.springsecurity.admin.repository.SysUserRepository;
import org.shanzhaozhen.springsecurity.admin.service.SysPermissionService;
import org.shanzhaozhen.springsecurity.bean.SysPermission;
import org.shanzhaozhen.springsecurity.bean.SysUser;
import org.shanzhaozhen.springsecurity.bean.SysUserInfo;
import org.shanzhaozhen.springsecurity.utils.ComparatorUtils;
import org.shanzhaozhen.springsecurity.utils.NullUtils;
import org.shanzhaozhen.springsecurity.utils.PasswordUtils;
import org.shanzhaozhen.springsecurity.utils.UserDetailsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringsecurityApplicationTests {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysUserInfoRepository sysUserInfoRepository;

    @Autowired
    private SysPermissionRepository sysPermissionRepository;

    @Autowired
    private SysPermissionService sysPermissionService;

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
    public void testMenus() {
        sysPermissionService.getMenu();

    }

    @Test
    public void testUserInfoSave() {
        SysUser newUser = new SysUser();
        newUser.setUsername("test1");
        newUser.setPassword(PasswordUtils.encryption("123456"));
        newUser.setAccountNonExpired(false);
        newUser.setAccountNonLocked(true);
        newUser.setCredentialsNonExpired(true);
        newUser.setEnabled(true);

        newUser.setSysUserInfo(new SysUserInfo());
        sysUserRepository.save(newUser);
    }

    @Test
    public void testGetUserInfo() {
        SysUser sysUser = sysUserRepository.findSysUserById(2);
        SysUserInfo one = sysUserInfoRepository.findSysUserInfoById(2);
        SysUserInfo two = sysUserInfoRepository.findSysUserInfoById(3);

        sysUser.setSysUserInfo(one);

        sysUserRepository.save(sysUser);

        System.out.println(sysUser);
    }

    @Test
    public void testFile() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int day = calendar.get(Calendar.DATE);

        String savePath = "C:/devFile/" + new SimpleDateFormat("yyyy-MM-dd").format(new Date());

        File file = new File(savePath);
        if (!file.exists()) {
            file.mkdir();
        }
    }


}
