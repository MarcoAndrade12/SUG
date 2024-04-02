package com.SUG.FLORA.model.DTOs;

import java.util.List;
import java.util.UUID;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.enums.EnumStatusUsuario;
import com.SUG.FLORA.interfaces.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
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

}
