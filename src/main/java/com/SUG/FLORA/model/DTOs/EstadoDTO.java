package com.SUG.FLORA.model.DTOs;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EstadoDTO extends DomainDTO{

    private String nome;
    private String sigla;
    private List<CidadeDTO> cidades;


}
