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
import com.SUG.FLORA.repository.UsuarioRepository;

@Service
public class UsuarioService  implements UserDetailsService{
    
    @Autowired
    UsuarioRepository usuarioRepository;

    public Profile getProfileByEmail(String email) {

        Usuario usuario = usuarioRepository.findByEmailAndDeletedFalse(email);
        return usuario.getProfile();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByEmailAndDeletedFalse(username);
        return usuario;
    }



}
