package com.SUG.FLORA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SUG.FLORA.configuration.SecurityConfiguration;

@Controller
@RequestMapping("/")
public class LoginController {
    
    @Autowired
    private SecurityConfiguration securityConfiguration;

    @GetMapping("login")
    public String getLogin() {

        System.out.println("GET");
        return "login";
    }

}
