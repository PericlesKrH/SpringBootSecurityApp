/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perilee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author perry
 */
@Controller
public class AuthenticationController {
    
    @RequestMapping("/loginPage")
    public String showLoginPage(){
    return "loginForm";
    }
}
