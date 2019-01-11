package org.shanzhaozhen.springsecurity.admin.repository;

import org.shanzhaozhen.springsecurity.bean.SysPermission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SysPermissionRepository extends JpaRepository<SysPermission, Integer> {

    public List<SysPermission> findAll();

    @Query(value = "select p.* " +
            "from sys_user u " +
            "left join sys_user_role sur on u.id = sur.user_id " +
            "left join sys_role r on r.id = sur.role_id " +
            "left join sys_role_permission srp on r.id = srp.role_id " +
            "left join sys_permission p on p.id = srp.permission_id " +
            "where u.username = ?1", nativeQuery = true)
    public List<SysPermission> findByUsername(String username);

//    public Set<SysPermission> findSysPermissionsByRoleId(Integer roleId);


}
