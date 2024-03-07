package com.SUG.FLORA.controller;

import java.util.UUID;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.SUG.FLORA.model.Usuario;

import com.SUG.FLORA.repository.UsuarioRepository;

@Controller
public class ExclusaoUsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @DeleteMapping("/usuarios/{id}")
    public String excluirUsuario(@PathVariable UUID id) {
        // Verificar se o usuário existe no banco de dados
        Optional<Usuario> optionalUsuario = usuarioRepository.findById(id);
        if (!optionalUsuario.isPresent()) {
            return "redirect:/usuarios?erro=Usuário não encontrado";
        }

        // Excluir o usuário do banco de dados
        usuarioRepository.delete(optionalUsuario.get());

        // Redirecionar para uma página ou rota após a exclusão bem-sucedida
        return "redirect:/usuarios?exclusao=success";
    }
}
