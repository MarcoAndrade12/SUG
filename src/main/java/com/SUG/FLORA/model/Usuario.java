package com.SUG.FLORA.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.enums.EnumStatusUsuario;
import com.SUG.FLORA.model.DTOs.UsuarioDTO;
import com.SUG.FLORA.model.endereco.Endereco;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Usuario extends Domain implements UserDetails{

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false, unique = false)
    private String senha;
    
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE},fetch = FetchType.EAGER)
    @JoinTable(name = "user_profile", joinColumns = @JoinColumn(name="usuario_id"), inverseJoinColumns = @JoinColumn(name="profile_id"))
    private List<Profile> profiles = new ArrayList<>();

    @Column(nullable = false, unique = false)
    private boolean consentimento;

    @Column(nullable = false, unique = false)
    private String nome;

    @Column(nullable = false, unique = false)
    private String sobrenome;

    @Column(nullable = false, unique = true)
    private String rg;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Enumerated(EnumType.STRING)
    @Column(nullable = true, unique = false)
    private EnumSexo sexo;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = false)
    private EnumStatusUsuario status;

    @OneToOne
    @JoinColumn(name = "endereco_id", nullable = true, unique = false)
    private Endereco endereco;
    
    
    public UsuarioDTO getDTO(){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setId(getId());
        usuarioDTO.setCreationDate(getCreationDate());
        usuarioDTO.setDeleted(isDeleted());
        usuarioDTO.setDeletedDate(getDeletedDate());
        usuarioDTO.setEmail(email);
        usuarioDTO.setProfiles(profiles.stream().map(profile -> profile.getDTO()).toList());
        usuarioDTO.setConsentimento(consentimento);
        usuarioDTO.setNome(nome);
        usuarioDTO.setSobrenome(sobrenome);
        usuarioDTO.setRg(rg);
        usuarioDTO.setCpf(cpf);
        usuarioDTO.setSexo(sexo);
        usuarioDTO.setStatus(status);

        if (endereco != null) {
            usuarioDTO.setEndereco(endereco.getDTO());
        }


        return usuarioDTO;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return profiles;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;    
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

   
    
}
