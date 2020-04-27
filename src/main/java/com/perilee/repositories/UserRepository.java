/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perilee.repositories;

import com.perilee.entities.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author perry
 */
@Repository
public interface UserRepository extends JpaRepository<MyUser, Integer>{
    
    MyUser findByUsername(String username);
}
