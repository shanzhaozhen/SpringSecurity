package org.shanzhaozhen.springsecurity.admin.repository;

import org.shanzhaozhen.springsecurity.bean.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysRoleRepository extends JpaRepository<SysRole, Integer> {

//    List<SysRole> findByUserName(String username);

}
