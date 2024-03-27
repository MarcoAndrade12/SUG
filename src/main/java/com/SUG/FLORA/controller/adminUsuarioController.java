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

    @GetMapping("/cadastro_usuario")
    public String getPageNovoUsuario(){
        return "admin/novo_usuario_admin";
    }

    @GetMapping("/editar_usuario")
    public String getPageEditarUsuario(){
        return "admin/editar_usuario_admin";
    }
    


}
