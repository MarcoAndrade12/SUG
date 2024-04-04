package com.SUG.FLORA.model.DTOs;

import java.util.ArrayList;
import java.util.List;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.endereco.Bairro;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BairroDTO extends IntDomainDTO implements DTO {
 
    private String nome;
    private List<LogradouroDTO> logradourosDTOs = new ArrayList<LogradouroDTO>();
    private List<cepDTO> cepsDTOs = new ArrayList<cepDTO>();

    @Override
    public Bairro getModel() {
        Bairro bairro = new Bairro();
        setDomainModel(bairro);
        
        bairro.setNome(nome);
        bairro.setLogradouros(
            logradourosDTOs
            .stream()
            .map(log -> log.getModel())
            .toList()
        );

        return bairro;
    }

}
