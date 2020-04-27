/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perilee.controller;

import com.perilee.entities.MyUser;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author perry
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private JdbcUserDetailsManager jdbcUserDetailsManager;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    

    @GetMapping("/home")
    public String adminHome() {
        return "admin-home";
    }

    @GetMapping("/register")
//    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerForm(Model model) {
        List<String> roles = new ArrayList();
        roles.add("ADMIN");
        roles.add("USER");
        roles.add("TEACHER");
        model.addAttribute("roles", roles);
        model.addAttribute("myuser", new MyUser());
        return "register-form";
    }

    @PostMapping("/registerUser")
    public String registerMyUser(@ModelAttribute("myuser") MyUser myuser) {
        System.out.println(myuser.getUsername());
        System.out.println(myuser.getPassword());
        System.out.println(myuser.getRoles());
        List<GrantedAuthority> authorities = new ArrayList();
        for (String role : myuser.getRoles()) {
            String temp = "ROLE_" + role;
            authorities.add(new SimpleGrantedAuthority(temp));
        }
        String encodedPassword = passwordEncoder.encode(myuser.getPassword());
        User user = new User(myuser.getUsername(), encodedPassword, authorities);
        jdbcUserDetailsManager.createUser(user);
        return "redirect:/admin/home";
    }

}
