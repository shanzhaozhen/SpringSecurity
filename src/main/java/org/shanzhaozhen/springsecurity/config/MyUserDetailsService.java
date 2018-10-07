package org.shanzhaozhen.springsecurity.config;

import org.shanzhaozhen.springsecurity.bean.SysPermission;
import org.shanzhaozhen.springsecurity.bean.SysUser;
import org.shanzhaozhen.springsecurity.repository.SysPermissionRepository;
import org.shanzhaozhen.springsecurity.repository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * 启动服务器时，通过FilterInvocationSecurityMetadataSource获得用户的所有角色及权限信息
 * 当用户登陆时，通过MyUserDetailsServiceImpl中的loadUserByUsername获得该登陆用户所有的权限
 * 发出请求时，通过FilterInvocationSecurityMetadataSource的getAttributes(Object url)获得需要的权限名
 * 最后在AccessDecisionManager中decide方法进行对比，如果用户拥有的权限名称和该url需要的权限名相同，那么放行，否则认证失败
 */
@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    SysUserRepository sysUserRepository;

    @Autowired
    SysPermissionRepository sysPermissionRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SysUser sysUser = sysUserRepository.findByUsername(username);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        sysUser.setPassword(encoder.encode("123456"));

        if (sysUser == null) {
            throw new UsernameNotFoundException("账号不存在");
        } else {
            //将数据库保存的权限存至登陆的账号里面
            Set<SysPermission> sysPermissions = sysPermissionRepository.findByUsername(username);
            if (sysPermissions != null) {
                Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
                for (SysPermission sysPermission : sysPermissions) {
                    grantedAuthorities.add(new SimpleGrantedAuthority(sysPermission.getName()));
                }
                sysUser.setAuthorities(grantedAuthorities);
            }
        }

        return sysUser;
    }

}
