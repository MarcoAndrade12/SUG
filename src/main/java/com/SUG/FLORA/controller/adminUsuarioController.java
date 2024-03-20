package com.SUG.FLORA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class adminUsuarioController {
    
    @GetMapping("/usuarios")
    public String getPage(){
        return "admin/usuarios_admin";
    }


}
