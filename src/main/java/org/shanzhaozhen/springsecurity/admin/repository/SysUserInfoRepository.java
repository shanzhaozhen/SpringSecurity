package org.shanzhaozhen.springsecurity.admin.repository;

import org.shanzhaozhen.springsecurity.bean.SysUserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SysUserInfoRepository extends JpaRepository<SysUserInfo, Integer> {

    SysUserInfo findSysUserInfoById(Integer id);

    @Query(value = "SELECT SysUserInfo FROM sys_user_info i INNER JOIN SysUser u ON i.id = u.sys_user_info_id " +
            "WHERE u.username = ?1", nativeQuery = true)
    SysUserInfo findSysUserInfoByUsername(String username);

}
