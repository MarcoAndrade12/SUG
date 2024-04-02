package com.SUG.FLORA.model.DTOs;

import java.util.List;

import com.SUG.FLORA.interfaces.DTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class EstadoDTO extends DomainDTO implements DTO {

    private String nome;
    private String sigla;
    private List<CidadeDTO> cidades;

}
