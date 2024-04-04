package com.SUG.FLORA.model.DTOs;

import com.SUG.FLORA.enums.EnumTipoLogradouro;
import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.interfaces.DTOEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnumTipoLogradouroDTO implements DTOEnum {
    private String tipo;

    @Override
    public EnumTipoLogradouro getModel() {
        return EnumTipoLogradouro.valueOf(tipo);
    }
}
