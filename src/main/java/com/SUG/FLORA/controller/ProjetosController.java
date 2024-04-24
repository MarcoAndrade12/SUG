package com.SUG.FLORA.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SUG.FLORA.model.Projeto;
import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.model.DTOs.ProjetoDTO;
import com.SUG.FLORA.services.ProjetoService;
import com.SUG.FLORA.services.UsuarioService;

@Controller
@RequestMapping("projetos")
public class ProjetosController {

    @Autowired
    ProjetoService projetoService;

    @Autowired
    UsuarioService usuarioService;

    @GetMapping("")
    public String getProjetos(@AuthenticationPrincipal UserDetails authenticated, Model model) {
        Usuario usuario = usuarioService.findUsuarioByEmail(authenticated.getUsername());

        List<ProjetoDTO> projetosDTO = projetoService.findAllDTOByUsuarioEmail(usuario.getEmail());

        model.addAttribute("projetos", projetosDTO);

        return "users/listar-projetos-users";
    }

    @GetMapping("/novo")
    public String getPage() {
        return "users/add-projeto-users";
    }

    @PostMapping("/novo")
    public String novoProjeto(@RequestBody MultiValueMap<String, String> body,
            @AuthenticationPrincipal Usuario usuario) {

        boolean nomeProjetoExist = projetoService.existsByNomeAndUsuarioDonoEmail(body.getFirst("nome"),
                usuario.getEmail());

        try {

            if (!nomeProjetoExist) {
                Projeto projeto = new Projeto();
                projeto.setNome(body.getFirst("nome"));
                projeto.setDescricao(body.getFirst("descricao"));
                projeto.setDeleted(false);

                projeto.setUsuarioDono(usuarioService.findUsuarioByEmail(usuario.getEmail()));

                projeto = projetoService.save(projeto);

                return "redirect:/projetos";
            } else {
                throw new Exception("Erro ao inserir projeto");
            }
        } catch (Exception error) {
            System.out.println(error.getLocalizedMessage());
            return "users/add-projeto-users";
        }

    }

}