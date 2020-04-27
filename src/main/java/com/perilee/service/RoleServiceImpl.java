/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perilee.service;

import com.perilee.entities.Role;
import com.perilee.repositories.RoleRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



/**
 *
 * @author perry
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepo;
    
    @Override
    public List<Role> getAllRole() {
        List<Role> roles = roleRepo.findAll();
        return roles;
    }
    
    
}
