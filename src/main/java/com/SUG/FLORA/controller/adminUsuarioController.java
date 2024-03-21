package com.SUG.FLORA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SUG.FLORA.model.DTOs.UsuarioDTO;
import com.SUG.FLORA.repository.UsuarioRepository;
import com.SUG.FLORA.services.UsuarioService;

import org.springframework.ui.Model;

@Controller
@RequestMapping("/usuarios")
public class adminUsuarioController {

    @Autowired
    UsuarioService usuarioService;
    
    @GetMapping("")
    public String getPage(Model model){

        List<UsuarioDTO> usuariosDTOs = usuarioService.findAllUsuariosDTOsByDeletedFalse();

        model.addAttribute("usuarios", usuariosDTOs);
        

        return "admin/usuarios_admin";
    }


}
