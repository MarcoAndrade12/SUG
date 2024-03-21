package com.SUG.FLORA.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.model.Profile;
import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.model.DTOs.UsuarioDTO;
import com.SUG.FLORA.repository.UsuarioRepository;

@Service
public class UsuarioService  implements UserDetailsService{
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> findAllUsuariosDTOsByDeletedFalse(){

        List<Usuario> usuarios = usuarioRepository.findAllByDeletedFalse();

        List<UsuarioDTO> usuarioDTOs;

        usuarioDTOs = usuarios.stream().map(
            usuario -> usuario.getDTO()
        ).toList();

        return usuarioDTOs;

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmailAndDeletedFalse(username);
        return usuario;
    }




}
