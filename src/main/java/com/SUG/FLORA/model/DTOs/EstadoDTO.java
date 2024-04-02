package com.SUG.FLORA.model.DTOs;

import java.util.List;

import com.SUG.FLORA.interfaces.DTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class EstadoDTO extends DomainDTO implements DTO {

    private String nome;
    private String sigla;
    private List<CidadeDTO> cidades;

}
