package com.SUG.FLORA.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.model.DTOs.BairroDTO;
import com.SUG.FLORA.model.DTOs.CidadeDTO;
import com.SUG.FLORA.model.DTOs.EnderecoDTO;
import com.SUG.FLORA.model.DTOs.EstadoDTO;
import com.SUG.FLORA.model.DTOs.LogradouroDTO;
import com.SUG.FLORA.model.DTOs.PaisDTO;
import com.SUG.FLORA.model.DTOs.SexoDTO;
import com.SUG.FLORA.model.DTOs.TipoLogradouroDTO;
import com.SUG.FLORA.model.DTOs.UsuarioDTO;
import com.SUG.FLORA.model.endereco.Pais;
import com.SUG.FLORA.repository.UsuarioRepository;
import com.SUG.FLORA.repository.endereco.PaisRepository;
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
        List<EstadoDTO> estadosDTOs = enderecoService.findAllEstadosDTOsByDeletedFalse();
        List<CidadeDTO> cidadesDTOs = enderecoService.findAllCidadesDTOsByDeletedFalse();
        List<BairroDTO> bairrosDTOs = enderecoService.findAllBairrosDTOsByDeletedFalse();
        List<LogradouroDTO> logradourosDTOs = enderecoService.findAllLogradourosDTOsByDeletedFalse();
        List<TipoLogradouroDTO> tiposLogradourosDTOs = enderecoService.findAllTiposLogradourosDTOsByDeletedFalse();

        model.addAttribute("sexos", sexoDTOs);
        model.addAttribute("paises", paisesDTOs);
        model.addAttribute("estados", estadosDTOs);
        model.addAttribute("cidades", cidadesDTOs);
        model.addAttribute("bairros", bairrosDTOs);
        model.addAttribute("tipos_logradouros", tiposLogradourosDTOs);
        model.addAttribute("logradouros", logradourosDTOs);

        return "admin/novo_usuario_admin";
    }

    @GetMapping("editar")
    public String getPageEditarUsuario() {
        return "admin/editar_usuario_admin";
    }

    @PostMapping("")
    public ResponseEntity<String> novoUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        System.out.println(usuarioDTO.getNome());
        System.out.println(usuarioDTO.getEmail());
        System.out.println(usuarioDTO.getEndereco().getLogradouro().getTipo());

        return ResponseEntity.ok().body("Usuário adicionado com sucesso");
    }

}
