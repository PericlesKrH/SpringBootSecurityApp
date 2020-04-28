/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perilee.repositories;

import com.perilee.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author perry
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    
    @Query("SELECT r FROM Role r WHERE r.name = :rname") //To Role einai opos to onoma tou Role Entity
    //@Query(value = "SELECT * FROM role WHERE rname = :rname", nativeQuery = true)
    Role findRoleByName(@Param("rname") String rname);
    
}
