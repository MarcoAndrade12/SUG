package com.SUG.FLORA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.model.DTOs.BairroDTO;
import com.SUG.FLORA.model.DTOs.CidadeDTO;
import com.SUG.FLORA.model.DTOs.EnumTipoLogradouroDTO;
import com.SUG.FLORA.model.DTOs.EstadoDTO;
import com.SUG.FLORA.model.DTOs.LogradouroDTO;
import com.SUG.FLORA.model.DTOs.PaisDTO;
import com.SUG.FLORA.model.DTOs.UsuarioDTO;
import com.SUG.FLORA.services.EnderecoService;
import com.SUG.FLORA.services.UsuarioService;

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

        List<PaisDTO> paisesDTOs = enderecoService.findAllPaisesDTOsByDeletedFalse();
        List<EnumTipoLogradouroDTO> tiposLogradourosDTOs = enderecoService.findAllTiposLogradourosDTOsByDeletedFalse();

        model.addAttribute("sexos", sexoDTOs);
        model.addAttribute("paises", paisesDTOs);
        model.addAttribute("tipos_logradouros", tiposLogradourosDTOs);

        return "admin/novo_usuario_admin";
    }

    @GetMapping("editar")
    public String getPageEditarUsuario() {
        return "admin/editar_usuario_admin";
    }

    @PostMapping("")
    public ResponseEntity<String> novoUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        Usuario usuario = usuarioDTO.getModel();

        return ResponseEntity.ok().body("Usuário adicionado com sucesso");
    }

}
