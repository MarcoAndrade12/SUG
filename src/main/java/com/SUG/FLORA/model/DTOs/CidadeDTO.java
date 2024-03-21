package com.SUG.FLORA.model.DTOs;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDTO extends DomainDTO{

    private String nome;
    private List<BairroDTO> bairros;

}
