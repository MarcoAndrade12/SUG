package com.SUG.FLORA.model.DTOs;

import java.util.List;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.endereco.Bairro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BairroDTO extends DomainDTO implements DTO {

    private String nome;
    private List<LogradouroDTO> logradourosDTOs;
    private List<cepDTO> cepsDTOs;

    @Override
    public Bairro getModel() {
        Bairro bairro = new Bairro();
        bairro.setId(getId());
        bairro.setCreationDate(getCreationDate());
        bairro.setDeleted(isDeleted());
        bairro.setDeletedDate(getDeletedDate());
        bairro.setLastUpdate(getLastUpdate());
        bairro.setNome(nome);
        bairro.setLogradouros(logradourosDTOs
            .stream()
            .map(log -> log.getModel()))
            .toList();


        return bairro;
    }

}
