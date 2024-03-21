package com.SUG.FLORA.model.DTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO extends DomainDTO{

    private int numero_casa;
    private String complemento;
    private PaisDTO pais;
    private EstadoDTO estado;
    private CidadeDTO cidade;
    private BairroDTO bairro;
    private LogradouroDTO logradouro;
    private cepDTO cep;

}
