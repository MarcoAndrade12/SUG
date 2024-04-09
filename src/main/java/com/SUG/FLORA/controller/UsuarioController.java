package com.SUG.FLORA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.exceptions.AtributoDuplicadoException;
import com.SUG.FLORA.exceptions.AtributoInvalidoException;
import com.SUG.FLORA.model.Profile;
import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.model.DTOs.CidadeDTO;
import com.SUG.FLORA.model.DTOs.EnumStatusDTO;
import com.SUG.FLORA.model.DTOs.EnumTipoLogradouroDTO;
import com.SUG.FLORA.model.DTOs.EstadoDTO;
import com.SUG.FLORA.model.DTOs.PaisDTO;
import com.SUG.FLORA.model.DTOs.ProfileDTO;
import com.SUG.FLORA.model.DTOs.UsuarioDTO;
import com.SUG.FLORA.services.EnderecoService;
import com.SUG.FLORA.services.UsuarioService;

import jakarta.transaction.Transactional;
import lombok.extern.java.Log;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    EnderecoService enderecoService;

    @GetMapping("")
    public String getPage(Model model) {

        List<UsuarioDTO> usuariosDTOs = usuarioService.findAllUsuariosDTOsByDeletedFalse();

        model.addAttribute("usuarios", usuariosDTOs);

        return "admin/usuarios_admin";
    }

    @GetMapping("cadastrar")
    public String getPageNovoUsuario(Model model) {

        EnumSexo[] sexoDTOs = EnumSexo.values();
        model.addAttribute("sexos", sexoDTOs);

        return "admin/novo_usuario_admin";
    }

    @GetMapping("editar")
    public String getPageEditarUsuario() {
        return "admin/editar_usuario_admin";
    }

    @PostMapping("")
    public ResponseEntity<String> novoUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        ProfileDTO profile = new ProfileDTO();
        profile.setName("ROLE_USER");
        
        EnumStatusDTO enumStatusDTO = new EnumStatusDTO();
        enumStatusDTO.setName("ATIVO");

        usuarioDTO.getProfiles().add(profile);
        usuarioDTO.setStatus(enumStatusDTO);
                
        try {
            Usuario usuario = usuarioDTO.getModel();
            Usuario usuarioSaved = usuarioService.salvarUsuario(usuario);
            
            return ResponseEntity.ok().body(usuarioSaved.getCpf());

        } catch (AtributoDuplicadoException error) {
            System.out.println(error.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error.getLocalizedMessage());
        
        } catch (AtributoInvalidoException error) {
            System.out.println(error.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getLocalizedMessage());
        } catch (Exception error) {
            System.out.println(error.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível cadastrar o usuário");
        }

    }

}