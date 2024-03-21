package com.SUG.FLORA.model.DTOs;

import java.util.List;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BairroDTO extends DomainDTO{

    private String nome;
    private List<LogradouroDTO> logradourosDTOs;
    private List<cepDTO> cepsDTOs;

}
