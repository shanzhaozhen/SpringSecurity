package org.shanzhaozhen.springsecurity.repository;

import org.shanzhaozhen.springsecurity.bean.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysUserRepository extends JpaRepository<SysUser, Integer> {

    SysUser findByUsername(String username);

}
