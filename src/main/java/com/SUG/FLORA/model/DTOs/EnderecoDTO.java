package com.SUG.FLORA.model.DTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO extends DomainDTO {

    private PaisDTO pais;
    private EstadoDTO estado;
    private CidadeDTO cidade;
    private BairroDTO bairro;
    private LogradouroDTO logradouro;
    private String complemento;
    private int numero;
    private cepDTO cep;

}
