package com.SUG.FLORA.model.DTOs;

import java.util.List;

import com.SUG.FLORA.enums.EnumRegiao;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegiaoDoPaisDTO extends DomainDTO{

    private EnumRegiao nome;
    private List<EstadoDTO> estados;

}
