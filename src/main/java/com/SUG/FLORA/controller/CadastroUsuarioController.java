package com.SUG.FLORA.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.repository.UsuarioRepository;

@Controller
public class CadastroUsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    // Método para exibir o formulário de registro quando o usuário acessa "/registro"
    @GetMapping("/registro")
    public String exibirFormularioRegistro() {
        return "registro"; // Retorna o nome da página de registro
    }

    // Método para processar o formulário de registro quando enviado via POST para "/registro"
    @PostMapping("/registro")
    public String cadastrarUsuario(@ModelAttribute("usuario") Usuario usuario) {
        // Verifica se o usuário já existe no banco de dados pelo e-mail
        if (usuarioRepository.findByEmail(usuario.getEmail()) != null) {
            // Se o usuário já existe, redireciona de volta para o formulário de registro com uma mensagem de erro
            return "redirect:/registro?erro=Usuário já existe";
        }

        // Codifica a senha antes de salvar no banco de dados
        usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));

        // Salva o usuário no banco de dados
        usuarioRepository.save(usuario);

        // Redireciona para a página de login após o registro bem-sucedido com uma mensagem de sucesso
        return "redirect:/login?registro=success";
    }
}