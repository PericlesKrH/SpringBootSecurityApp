/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.perilee;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

/**
 *
 * @author perry
 */
@EnableWebSecurity
public class MyWebSecurityConfigurer extends WebSecurityConfigurerAdapter{

    @Autowired
    private DataSource dataSource;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()//Restrict access based on the HttpServletRequest
                .antMatchers("/").hasAnyRole("USER","ADMIN","TEACHER")//all users will have access ("/")                                 
                .antMatchers("/admin/**").hasRole("ADMIN")// me ("/admin/**") fernei oles tis selides pou ksekinoun apo /admin
                .antMatchers("/teacher/**").hasRole("TEACHER")// me ("/teacher/**") fernei oles tis selides pou ksekinoun apo /teacher
                .and()
                .formLogin()//we are going to customise the form login process
                .loginPage("/loginPage")//show my form
                .loginProcessingUrl("/authenticate")//login form will post data to this url to check username and password
                .permitAll()//allow everyone to see login page. Dont have to be logged in
                .and()
                .logout()
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/access-denied")
                ;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        String [] roles = {"ADMIN", "USER"};
//        auth.inMemoryAuthentication().withUser("user").password("p53jl6pxcv").roles(roles);
//---------Gia na paizo tis selides xoris vasi-----------
//        auth.inMemoryAuthentication()
//                .withUser("user").password("{noop}12345").roles("USER")
//                .and()
//                .withUser("admin").password("{noop}p53jl6pxcv").roles("ADMIN")
//                .and()
//                .withUser("teacher").password("{noop}12345").roles("TEACHER");
//---------Gia na paizo me vasi-------------
            auth.jdbcAuthentication()
                    .dataSource(dataSource)
                   
                    //paizei me HSQL vasi
//                    .withDefaultSchema() //dn paizei me mySQL giati dn uparxei varchar_ignorecase timi pou prospathei na ftiaksei to spring
                    ;
    }
    
    @Bean
    public JdbcUserDetailsManager jdbsUserDetailsManager(){
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager();
        manager.setDataSource(dataSource);
        return manager;
    }
    
    @Bean
    public PasswordEncoder passwordEncoder(){
    return new BCryptPasswordEncoder();
    }
}
