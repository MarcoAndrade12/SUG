package com.SUG.FLORA.model.DTOs;

import java.util.ArrayList;
import java.util.List;

import com.SUG.FLORA.enums.EnumStatusUsuario;
import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.model.Profile;
import com.SUG.FLORA.model.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO extends UuidDomainDTO implements DTO {

    private String nome;
    private String sobrenome;
    private String rg;
    private String cpf;
    private EnumSexoDTO sexo = new EnumSexoDTO();
    private String email;
    private List<ProfileDTO> profiles = new ArrayList<ProfileDTO>();
    private EnderecoDTO endereco = new EnderecoDTO();
    private EnumStatusDTO status = new EnumStatusDTO();
    private boolean consentimento;

    public Usuario getModel() {

        Usuario usuario = new Usuario();

        usuario.setId(getId());
        usuario.setCreationDate(getCreationDate());
        usuario.setDeleted(isDeleted());
        usuario.setDeletedDate(getDeletedDate());
        usuario.setLastUpdate(getLastUpdate());
        usuario.setNome(nome);
        usuario.setSobrenome(sobrenome);
        usuario.setRg(rg);
        usuario.setCpf(cpf);
        usuario.setSexo(sexo.getModel());
        usuario.setEmail(email);
        
        usuario.setProfiles((List<Profile>) profiles
            .stream()
            .map(
                profile -> profile.getModel())
            .toList());

        usuario.setStatus(status.getModel());
        usuario.setConsentimento(consentimento);

        return usuario;
    }

}
