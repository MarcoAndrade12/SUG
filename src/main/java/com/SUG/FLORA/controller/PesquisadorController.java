package com.SUG.FLORA.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pesquisador")
public class PesquisadorController {
    
    @GetMapping("/register")
    public String getPageCadastro(){
        return "userRegister";
    }

}
