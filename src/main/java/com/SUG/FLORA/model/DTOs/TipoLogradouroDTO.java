package com.SUG.FLORA.model.DTOs;

import com.SUG.FLORA.interfaces.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TipoLogradouroDTO extends DomainDTO implements DTO {
    private String tipo;
}
