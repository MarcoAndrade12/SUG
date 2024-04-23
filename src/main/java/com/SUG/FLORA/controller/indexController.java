package com.SUG.FLORA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.repository.ProfileRepository;
import com.SUG.FLORA.services.UsuarioService;

@Controller
@RequestMapping("/")
public class indexController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ProfileRepository profileRepository;

    @GetMapping("index")
    public String getPage(@AuthenticationPrincipal Usuario usuario) {

    	System.out.println(usuario.getId());
    	
        boolean isAdmin = usuario.getAuthorities()
                .stream().anyMatch(profile -> profile.getAuthority().equals("ROLE_ADMIN"));

        if (isAdmin) {
            return "admin/index_admin";
        }

        return "index";
    }
    
    @GetMapping("temp")
    public String getPage2(@AuthenticationPrincipal Usuario usuario) {

    	System.out.println(usuario.getId());
    	
        boolean isAdmin = usuario.getAuthorities()
                .stream().anyMatch(profile -> profile.getAuthority().equals("ROLE_ADMIN"));

        if (isAdmin) {
            return "temp/login";
        }

        return "index";
    }
    
    @GetMapping("temp2")
    public String getPage3(@AuthenticationPrincipal Usuario usuario) {

    	System.out.println(usuario.getId());
    	
        boolean isAdmin = usuario.getAuthorities()
                .stream().anyMatch(profile -> profile.getAuthority().equals("ROLE_ADMIN"));

        if (isAdmin) {
            return "temp/editar-cadastro";
        }

        return "index";
    }

}
