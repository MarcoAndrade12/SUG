package com.SUG.FLORA.model.DTOs;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.endereco.Logradouro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogradouroDTO extends IntDomainDTO implements DTO {

    private EnumTipoLogradouroDTO tipo = new EnumTipoLogradouroDTO();
    private String nome;
    private cepDTO cep = new cepDTO();

    @Override
    public Logradouro getModel() {
        Logradouro logradouro = new Logradouro();
        logradouro.setId(getId());
        logradouro.setCreationDate(getCreationDate());
        logradouro.setDeleted(isDeleted());
        logradouro.setDeletedDate(getDeletedDate());
        logradouro.setLastUpdate(getLastUpdate());
        logradouro.setNome(nome);
        logradouro.setTipo(tipo.getModel());
        logradouro.setCep(cep.getModel());

        return logradouro;
    }

}
