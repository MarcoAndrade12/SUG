package com.SUG.FLORA.model.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO extends IntDomainDTO {

    private PaisDTO pais = new PaisDTO();
    private EstadoDTO estado = new EstadoDTO();
    private CidadeDTO cidade = new CidadeDTO();
    private BairroDTO bairro = new BairroDTO();
    private LogradouroDTO logradouro = new LogradouroDTO();
    private String complemento;
    private int numero;
    private cepDTO cep = new cepDTO();

}
