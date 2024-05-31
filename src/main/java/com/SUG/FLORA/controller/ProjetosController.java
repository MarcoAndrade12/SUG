package com.SUG.FLORA.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SUG.FLORA.model.Coleta;
import com.SUG.FLORA.model.Projeto;
import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.model.DTOs.ProjetoDTO;
import com.SUG.FLORA.services.ColetaService;
import com.SUG.FLORA.services.ProjetoService;
import com.SUG.FLORA.services.UsuarioService;

import jakarta.transaction.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("projetos")
public class ProjetosController {

    @Autowired
    ProjetoService projetoService;

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ColetaService coletaService;

    @GetMapping("")
    public String getProjetos(@AuthenticationPrincipal UserDetails authenticated, Model model) {
        Usuario usuario = usuarioService.findUsuarioByEmail(authenticated.getUsername());

        List<ProjetoDTO> allProjetosDTO = projetoService.findAllDTOByUsuarioEmail(usuario.getEmail());

        List<ProjetoDTO> projetosAtivosDTOs = allProjetosDTO.stream().filter(projeto -> projeto.isAtivo()).toList();

        List<ProjetoDTO> projetosInativosDTOs = allProjetosDTO.stream().filter(projeto -> !projeto.isAtivo()).toList();

        model.addAttribute("projetosAtivos", projetosAtivosDTOs);
        model.addAttribute("projetosInativos", projetosInativosDTOs);

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

    @GetMapping("/meuprojeto/{id}")
    public String getMeuProjeto(@PathVariable String id, Model model) {
        UUID projeto_id = UUID.fromString(id);
        Projeto projeto = projetoService.findById(projeto_id);
        Integer codigo = coletaService.getLastCodigoColetaByProjetoId(projeto_id);
        if (codigo != null) {
            codigo++;
        } else {
            codigo = 0;
        }

        model.addAttribute("projeto", projeto.getDTO());
        model.addAttribute("ultimo_codigo", codigo + 1);

        return "users/listar-coletas-users";
    }

    @GetMapping("editar/{id}")
    public String editProjeto(@PathVariable String id, Model model) {
        UUID projeto_id = UUID.fromString(id);
        Projeto projeto = projetoService.findById(projeto_id);
        model.addAttribute("projeto", projeto.getDTO());

        return "users/editar-projeto-users";
    }

    @PostMapping("editar/{id}")
    @Transactional
    public String postEditProjeto(@RequestBody MultiValueMap<String, String> post,
            @AuthenticationPrincipal UserDetails logged, @PathVariable String id, Model model) {
        Projeto projeto = projetoService.findById(UUID.fromString(id));

        if (projeto.getUsuarioDono().getEmail().equals(logged.getUsername())) {

            projeto.setNome(post.getFirst("nome"));
            projeto.setDescricao(post.getFirst("descricao"));

            model.addAttribute("projeto", projeto.getDTO());

        }

        return "users/editar-projeto-users";
    }

    @Transactional
    @GetMapping("inativar/{id}")
    public String inativarProjeto(@PathVariable String id) {

        Projeto projeto = projetoService.findById(UUID.fromString(id));

        projeto.setLastUpdate(LocalDateTime.now());
        projeto.setAtivo(false);

        return "redirect:/projetos";
    }

    @Transactional
    @GetMapping("ativar/{id}")
    public String ativarProjeto(@PathVariable String id) {

        Projeto projeto = projetoService.findById(UUID.fromString(id));

        projeto.setLastUpdate(LocalDateTime.now());
        projeto.setAtivo(true);

        return "redirect:/projetos";
    }

}
