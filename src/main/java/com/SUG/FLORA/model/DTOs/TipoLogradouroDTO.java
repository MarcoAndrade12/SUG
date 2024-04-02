package com.SUG.FLORA.model.DTOs;

import com.SUG.FLORA.interfaces.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoLogradouroDTO extends DomainDTO implements DTO {
    private String tipo;
}
