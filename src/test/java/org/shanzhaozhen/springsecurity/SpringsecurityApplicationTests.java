package org.shanzhaozhen.springsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.shanzhaozhen.springsecurity.bean.SysPermission;
import org.shanzhaozhen.springsecurity.bean.SysUser;
import org.shanzhaozhen.springsecurity.repository.SysPermissionRepository;
import org.shanzhaozhen.springsecurity.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

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

        System.out.println(sysPermissions.get(1).toString());

    }

}
