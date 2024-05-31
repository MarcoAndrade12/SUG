package com.SUG.FLORA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.services.UsuarioService;

import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping("perfil")
public class PerfilController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("editar-usuario")
    public String getPerfil(Model model, @AuthenticationPrincipal Usuario loged) {
        Usuario usuario = usuarioService.findUsuarioByEmail(loged.getEmail());
        // Obtenha as informações do usuário logado
        model.addAttribute("usuario", usuario.getDTO());
        return "users/editusuario"; // Retorne a página de edição de usuário
    }
    @PostMapping("editar-usuario")
    @Transactional
    public String setPerfil(@RequestBody MultiValueMap<String, String> post, @AuthenticationPrincipal Usuario loged) {
        Usuario usuario = usuarioService.findUsuarioByEmail(loged.getEmail());
        
        usuario.setNome(post.getFirst("nome"));
        usuario.setSobrenome(post.getFirst("sobrenome"));
        usuario.setCpf(post.getFirst("cpf"));
        usuario.setRg(post.getFirst("rg"));
        usuario.setEmail(post.getFirst("email"));
        
        
        return "redirect:/projetos";
    }
    
    

    // Se você também deseja lidar com o envio do formulário de edição, você pode adicionar o método POST correspondente aqui
    // @PostMapping("editar-usuario")
    // public String postPerfil(@ModelAttribute Usuario usuario) {
    //     usuarioService.atualizarUsuario(usuario);
    //     return "redirect:/perfil"; // Redirecionar de volta para a página de perfil
    // }
}
