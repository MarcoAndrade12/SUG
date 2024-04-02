package com.SUG.FLORA.model.DTOs;

import java.util.List;

import com.SUG.FLORA.interfaces.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaisDTO extends DomainDTO implements DTO {

    private String nome;
    private String sigla;
    private List<RegiaoDoPaisDTO> regioes;
    private List<EstadoDTO> estados;

}
