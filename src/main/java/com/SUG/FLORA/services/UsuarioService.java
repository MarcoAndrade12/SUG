package com.SUG.FLORA.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.exceptions.AtributoDuplicadoException;
import com.SUG.FLORA.exceptions.AtributoInvalidoException;
import com.SUG.FLORA.exceptions.AtributoJaExisteException;
import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.model.DTOs.UsuarioDTO;
import com.SUG.FLORA.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService  implements UserDetailsService{
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public List<UsuarioDTO> findAllUsuariosDTOsByDeletedFalse(){

        List<Usuario> usuarios = usuarioRepository.findAllByDeletedFalse();

        List<UsuarioDTO> usuarioDTOs;

        usuarioDTOs = usuarios.stream().map(
            usuario -> usuario.getDTO()
        ).toList();

        return usuarioDTOs;

    }

    public UsuarioDTO getUsuarioDTOByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario.getDTO();
    }

    public Usuario getUsuarioByEmail(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario;
    }

    public boolean EmailExists(String email) {
        Usuario usuario = usuarioRepository.findByEmail(email);
        return usuario!= null;
    }

    public boolean salvarUsuario(Usuario usuario) {
        if (EmailExists(usuario.getEmail())) {
            throw new AtributoDuplicadoException("Já existe um usuario com este email");
        }
        
        try {
            usuarioRepository.save(usuario);
            return true;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public boolean isValidEmail(String email) {
        if (email.contains("@") && email.contains(".com")) {
            return true;
        } else {
            return false;
        }
    }

    @Transactional
    public Usuario alterarEmailUsuario(UUID id, String email) {

        if (!isValidEmail(email)) {
            throw new AtributoInvalidoException("Email invalido");
        }

        Usuario usuario = usuarioRepository.findById(id).get();

        if (usuario !=null && usuario.getEmail() != email) {
            usuario.setEmail(email);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o email do usuário");
        }

    }

    @Transactional
    public Usuario alterarNomeUsuario(UUID id, String nome) {
        if (nome.isEmpty()) {
            throw new AtributoInvalidoException("O nome não pode ser vazio!");
        }

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario != null && usuario.getNome() != nome) {
            usuario.setNome(nome);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o nome do usuário");
        }
    }

    @Transactional
    public Usuario alterarSobrenomeUsuario(UUID id, String sobrenome) {
        if (sobrenome.isEmpty()) {
            throw new AtributoInvalidoException("O sobrenome não pode ser vazio!");
        }

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario != null && usuario.getSobrenome() != sobrenome) {
            usuario.setSobrenome(sobrenome);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o sobrenome do usuário");
        }
    }

    @Transactional
    public Usuario alterarRgUsuario(UUID id, String rg) {
        if (rg.isEmpty()) {
            throw new AtributoInvalidoException("O rg não pode ser vazio!");
        }

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario != null && usuario.getRg() != rg) {
            usuario.setRg(rg);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o rg do usuário");
        }
    }

    @Transactional
    public Usuario alterarCpfUsuario(UUID id, String cpf) {
        if (cpf.isEmpty()) {
            throw new AtributoInvalidoException("O cpf não pode ser vazio!");
        }

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario != null && usuario.getCpf() != cpf) {
            usuario.setCpf(cpf);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o cpf do usuário");
        }
    }

    @Transactional
    public Usuario alterarSexoUsuario(UUID id, EnumSexo sexo) {

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario != null && usuario.getSexo() != sexo) {
            usuario.setSexo(sexo);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o sexo do usuário");
        }
    }

    @Transactional
    public Usuario alterarSenhaUsuario(UUID id, String senha) {

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario != null && usuario.getSenha() != senha) {
            usuario.setSenha(senha);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é a senha do usuário");
        }
    }

    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmailAndDeletedFalse(username);
        return usuario;
    }

    


}
