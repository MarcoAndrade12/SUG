package com.SUG.FLORA.model.DTOs;

import com.SUG.FLORA.enums.EnumTipoLogradouro;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogradouroDTO extends DomainDTO{

    private EnumTipoLogradouro tipo;
    private String nome;
    private cepDTO cep;
    
}
