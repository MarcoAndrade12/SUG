package com.SUG.FLORA.model.DTOs;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class cepDTO extends DomainDTO{

    private String numero;
    private String altitude;
    private String longitude;

}
