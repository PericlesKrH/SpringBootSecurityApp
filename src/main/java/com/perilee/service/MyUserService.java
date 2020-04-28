/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perilee.service;

import com.perilee.entities.MyUser;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 *
 * @author perry
 */
public interface MyUserService extends UserDetailsService{

    public void saveUser(MyUser myuser);
    MyUser findByUsername(String username);
    
}
