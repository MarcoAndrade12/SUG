package com.SUG.FLORA.model.DTOs;

import java.util.ArrayList;
import java.util.List;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.endereco.Cidade;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDTO extends IntDomainDTO implements DTO {

    private String nome;

    @Override
    public Cidade getModel() {
        Cidade cidade = new Cidade();
        setDomainModel(cidade);
        cidade.setNome(nome);

        return cidade;
    }

}
