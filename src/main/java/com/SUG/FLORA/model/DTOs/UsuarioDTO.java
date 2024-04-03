package com.SUG.FLORA.model.DTOs;

import java.util.List;

import com.SUG.FLORA.enums.EnumStatusUsuario;
import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.model.Profile;
import com.SUG.FLORA.model.Usuario;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO extends DomainDTO implements DTO {

    private String nome;
    private String sobrenome;
    private String rg;
    private String cpf;
    private SexoDTO sexo;
    private String email;
    private List<ProfileDTO> profiles;
    private EnderecoDTO endereco;
    private StatusDTO status;
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
