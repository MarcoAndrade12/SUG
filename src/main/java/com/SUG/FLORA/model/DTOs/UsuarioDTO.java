package com.SUG.FLORA.model.DTOs;

import java.util.List;
import java.util.UUID;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.enums.EnumStatusUsuario;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDTO extends DomainDTO{

    private String email;
    private List<ProfileDTO> profiles;
    private boolean consentimento;
    private String nome;
    private String sobrenome;
    private String rg;
    private String cpf;
    private EnumSexo sexo;
    private EnumStatusUsuario status;
    private EnderecoDTO endereco;
    

}
