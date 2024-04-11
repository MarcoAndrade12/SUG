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
import com.SUG.FLORA.enums.EnumStatusUsuario;
import com.SUG.FLORA.exceptions.AtributoDuplicadoException;
import com.SUG.FLORA.exceptions.AtributoInvalidoException;
import com.SUG.FLORA.exceptions.AtributoJaExisteException;
import com.SUG.FLORA.exceptions.UsuarioNaoEncontrado;
import com.SUG.FLORA.model.Profile;
import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.model.DTOs.UsuarioDTO;
import com.SUG.FLORA.model.endereco.Endereco;
import com.SUG.FLORA.repository.UsuarioRepository;

import jakarta.transaction.Transactional;

@Service
public class UsuarioService  implements UserDetailsService{
    
    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    EnderecoService enderecoService;

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

    public Usuario salvarUsuario(Usuario usuario) {
        if (EmailExists(usuario.getEmail())) {
            throw new AtributoDuplicadoException("Já existe um usuario com este email");
        }

        if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
            throw new AtributoInvalidoException("O Email não pode ser vazio");
        }

        if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
            throw new AtributoInvalidoException("A senha não pode ser vazia");
        }

        System.out.println(usuario.getSexo());
        
        try {
            Usuario usuarioSaved = usuarioRepository.save(usuario);
            return usuarioSaved;
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

    public Usuario alterarEmailUsuario(UUID id, String email) throws UsuarioNaoEncontrado {

        if (!isValidEmail(email)) {
            throw new AtributoInvalidoException("Email invalido");
        }

        Usuario usuario = usuarioRepository.findById(id).get();

        if (usuario == null) {
            throw new UsuarioNaoEncontrado("Usuário não encontrado");
        } else if(usuario.getEmail() != email) {
            usuario.setEmail(email);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o email do usuário");
        }

    }

    public Usuario alterarNomeUsuario(UUID id, String nome) throws UsuarioNaoEncontrado {
        if (nome.isEmpty()) {
            throw new AtributoInvalidoException("O nome não pode ser vazio!");
        }

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario == null) {
            throw new UsuarioNaoEncontrado("Usuário não encontrado");
        } else if(usuario.getNome() != nome) {
            usuario.setNome(nome);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o nome do usuário");
        }
    }

    public Usuario alterarSobrenomeUsuario(UUID id, String sobrenome) throws UsuarioNaoEncontrado {
        if (sobrenome.isEmpty()) {
            throw new AtributoInvalidoException("O sobrenome não pode ser vazio!");
        }

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario == null) {
            throw new UsuarioNaoEncontrado("Usuário não encontrado");
        } else if(usuario.getSobrenome() != sobrenome) {
            usuario.setSobrenome(sobrenome);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o sobrenome do usuário");
        }
    }

    public Usuario alterarRgUsuario(UUID id, String rg) throws UsuarioNaoEncontrado {
        if (rg.isEmpty()) {
            throw new AtributoInvalidoException("O rg não pode ser vazio!");
        }

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario == null) {
            throw new UsuarioNaoEncontrado("Usuário não encontrado");
        } else if(usuario.getRg() != rg) {
            usuario.setRg(rg);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o rg do usuário");
        }
    }

    public Usuario alterarCpfUsuario(UUID id, String cpf) throws UsuarioNaoEncontrado {
        if (cpf.isEmpty()) {
            throw new AtributoInvalidoException("O cpf não pode ser vazio!");
        }

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario == null) {
            throw new UsuarioNaoEncontrado("Usuário não encontrado");
        } else if(usuario.getCpf() != cpf) {
            usuario.setCpf(cpf);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o cpf do usuário");
        }
    }

    public Usuario alterarSexoUsuario(UUID id, EnumSexo sexo) throws UsuarioNaoEncontrado {

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario == null) {
            throw new UsuarioNaoEncontrado("Usuário não encontrado");
        } else if(usuario.getSexo() != sexo) {
            usuario.setSexo(sexo);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o sexo do usuário");
        }
    }

    public Usuario alterarConsentimentoUsuario(UUID id, boolean consentimento) throws UsuarioNaoEncontrado {

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario == null) {
            throw new UsuarioNaoEncontrado("Usuário não encontrado");
        } else if(usuario.isConsentimento() != consentimento) {
            usuario.setConsentimento(consentimento);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o consentimento do usuário");
        }
    }

    public Usuario alterarStatusUsuario(UUID id, EnumStatusUsuario status) throws UsuarioNaoEncontrado {
        
        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario == null) {
            throw new UsuarioNaoEncontrado("Usuário não encontrado");
        } else if(usuario.getStatus() != status) {
            usuario.setStatus(status);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o status do usuário");
        }
    }

    public Usuario alterarEnderecoUsuario(UUID id, Endereco endereco) throws UsuarioNaoEncontrado {

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario == null) {
            throw new UsuarioNaoEncontrado("Usuário não encontrado");
        } else if(enderecoService.findEnderecoById(endereco.getId()) == null) {
            throw new AtributoInvalidoException("Endereço não foi salvo no banco anteriormente");
        } else if(usuario.getEndereco() != endereco) {
            usuario.setEndereco(endereco);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o endereço do usuário");
        }
    }


    public Usuario AddProfileUsuario(UUID id, Profile profile) throws UsuarioNaoEncontrado {

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario == null) {
            throw new UsuarioNaoEncontrado("Usuário não encontrado");
        } else if(!usuario.getProfiles().contains(profile)) {
            usuario.getProfiles().add(profile);
            return usuario;
        } else {
            throw new AtributoJaExisteException("Este já é o perfil do usuário");
        }
    }

    public Usuario RemoveProfileUsuario(UUID id, Profile profile) throws UsuarioNaoEncontrado {

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario == null) {
            throw new UsuarioNaoEncontrado("Usuário não encontrado");
        } else if(usuario.getProfiles().contains(profile)) {
            usuario.getProfiles().remove(profile);
            return usuario;
        } else {
            throw new AtributoJaExisteException("O usuário não possui este perfil");
        }
    }

    public Usuario alterarSenhaUsuario(UUID id, String senha) throws UsuarioNaoEncontrado {

        Usuario usuario = usuarioRepository.findById(id).get();
        if (usuario == null) {
            throw new UsuarioNaoEncontrado("Usuário não encontrado");
        } else if(usuario.getSenha() != senha) {
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
