package com.SUG.FLORA.model.DTOs;

import com.SUG.FLORA.enums.EnumTipoLogradouro;
import com.SUG.FLORA.interfaces.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogradouroDTO extends DomainDTO implements DTO {

    private TipoLogradouroDTO tipo;
    private String nome;
    private cepDTO cep;

}
