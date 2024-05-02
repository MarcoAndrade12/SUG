package com.SUG.FLORA.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.enums.EnumStatusUsuario;
import com.SUG.FLORA.model.Endereco;
import com.SUG.FLORA.model.Profile;
import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.model.DTOs.UsuarioDTO;
import com.SUG.FLORA.services.EnderecoService;
import com.SUG.FLORA.services.UsuarioService;

import jakarta.transaction.Transactional;

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

        return "admin/list-usuario";
    }

    
    
    @GetMapping("editar-usuario/{id}")
    public String getPage(Model model, @PathVariable String id) {

        Usuario u = usuarioService.findById(UUID.fromString(id));
        System.out.println("Id -> " + id);
        if (u != null) {
            System.out.println("Editando Usuario -> " + u.getNome());
            model.addAttribute("u", u);
            model.addAttribute("sexos", EnumSexo.values());
        }

        return "admin/editar_usuario_admin";
    }

    @PostMapping("editar-usuario/{id}")
    @Transactional
    public String salvarEdicaoUsuario(Model model, @PathVariable String id,
            @RequestBody MultiValueMap<String, String> body) {

        Usuario u = usuarioService.findById(UUID.fromString(id));

        if (u != null) {
            u.setNome(body.getFirst("primeiro_nome"));
            u.setSobrenome(body.getFirst("sobrenome"));
            u.setEmail(body.getFirst("email"));
            u.setRg(body.getFirst("rg"));
            u.setCpf(body.getFirst("cpf"));
            u.setSexo(EnumSexo.stringToSexo(body.getFirst("sexo")));
            u.getEndereco().setPais(body.getFirst("pais"));
            u.getEndereco().setEstado(body.getFirst("estado"));
            u.getEndereco().setCidade(body.getFirst("cidade"));
            System.out.println("Editando Usuario -> " + u.getNome());
            model.addAttribute("u", u);
            model.addAttribute("sexos", EnumSexo.values());
        }

        return "admin/editar_usuario_admin";
    }

    @GetMapping("remover-usuario/{id}")
    @Transactional
    public String removerUsuario( RedirectAttributes redirectAttrs, @PathVariable String id
           ) throws IOException {

        Usuario u = usuarioService.findById(UUID.fromString(id));

        u.setDeleted(true);
        u.setDeletedDate(LocalDateTime.now());

        
        redirectAttrs.addFlashAttribute("message", "success:Usuário removido com sucesso");
        
        return "redirect:/usuarios";
    }
    
    @GetMapping("cadastrar")
    public String getPageNovoUsuario(Model model) {

        EnumSexo[] sexoDTOs = EnumSexo.values();
        model.addAttribute("sexos", sexoDTOs);

      //  return "admin/novo_usuario_admin";
        return "admin/add-usuario";
    }

    @PostMapping("")
    public ResponseEntity<String> novoUsuario(@RequestBody MultiValueMap<String, String> body) {

        try {
            Usuario user = new Usuario();

            user.setNome(body.getFirst("primeiro_nome"));
            user.setSobrenome(body.getFirst("sobrenome"));
            user.setRg(body.getFirst("rg"));
            user.setCpf(body.getFirst("cpf"));
            user.setSexo(EnumSexo.stringToSexo(body.getFirst("sexo")));
            user.setEmail(body.getFirst("email"));
            user.setStatus(EnumStatusUsuario.ATIVO);
            user.setSenha("mudar@123");

            Profile profile = new Profile();
            profile.setName("ROLE_USER");

            List<Profile> profiles = new ArrayList<Profile>();
            profiles.add(profile);
            user.setProfiles(profiles);

            Endereco endereco = new Endereco();
            endereco.setCidade(body.getFirst("cidade"));
            endereco.setEstado(body.getFirst("estado"));
            endereco.setPais(body.getFirst("pais"));

            user.setEndereco(endereco);

            Usuario usuarioSaved = usuarioService.salvarUsuario(user);

            return ResponseEntity.ok().body(usuarioSaved.getCpf());

        } catch (Exception error) {
            error.printStackTrace();
            System.out.println(error.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getMessage());
        }

    }


    @PostMapping("excluir_usuario")
    public ResponseEntity<String> excluirUsuario(@RequestBody MultiValueMap<String, String> body){
        
        try {

            Usuario usuario = usuarioService.findById(UUID.fromString(body.getFirst("id")));
            if (usuario.isAccountNonExpired()) {
                System.out.println(usuario.getNome());
            }
            return ResponseEntity.ok().body("Usuario deletado com sucesso");

        } catch (Exception erro) {
            System.out.println(erro);
            return ResponseEntity.badRequest().body(erro.getLocalizedMessage());
        }



    }

}
