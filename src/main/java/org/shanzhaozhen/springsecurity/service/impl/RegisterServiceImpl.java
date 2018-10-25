package org.shanzhaozhen.springsecurity.service.impl;

import org.shanzhaozhen.springsecurity.bean.SysUser;
import org.shanzhaozhen.springsecurity.repository.SysUserRepository;
import org.shanzhaozhen.springsecurity.service.RegisterService;
import org.shanzhaozhen.springsecurity.utils.MessageUtils;
import org.shanzhaozhen.springsecurity.utils.NullUtils;
import org.shanzhaozhen.springsecurity.utils.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private SysUserRepository sysUserRepository;

    @Override
    @Modifying
    @Transactional
    public Map<String, Object> RegisterNewUser(SysUser sysUser) {
        if (NullUtils.isNull(sysUser.getUsername())) {
            return MessageUtils.resultFailureMessage("填写的用户名有误！");
        }
        if (NullUtils.isNull(sysUser.getPassword())) {
            return MessageUtils.resultFailureMessage("填写的密码有误！");
        }
        int count = sysUserRepository.countByUsername(sysUser.getUsername());
        if (count > 0) {
            return MessageUtils.resultFailureMessage("注册失败，用户名已存在！");
        }
        SysUser newUser = new SysUser();
        newUser.setUsername(sysUser.getUsername());
        newUser.setPassword(PasswordUtils.encryption(sysUser.getPassword()));
        sysUser.setAccountNonExpired(false);
        sysUser.setAccountNonLocked(true);
        sysUser.setCredentialsNonExpired(true);
        sysUser.setEnabled(true);
        sysUserRepository.save(sysUser);
        return MessageUtils.resultSuccessMessage("注册成功，等待管理员通过审核！");
    }

    @Override
    public Map<String, Boolean> checkUsername(String username) {
        int count = sysUserRepository.countByUsername(username);
        boolean valid = false;
        Map<String, Boolean> map = new HashMap<String, Boolean>();
        if (count > 0) {
            map.put("valid", false);
        } else {
            map.put("valid", true);
        }
        return map;
    }

}
