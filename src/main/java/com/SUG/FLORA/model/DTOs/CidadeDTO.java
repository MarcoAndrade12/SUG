package com.SUG.FLORA.model.DTOs;

import java.util.List;

import com.SUG.FLORA.interfaces.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CidadeDTO extends DomainDTO implements DTO {

    private String nome;
    private List<BairroDTO> bairros;

}
