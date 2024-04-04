package com.SUG.FLORA.model.DTOs;

import com.SUG.FLORA.enums.EnumStatusUsuario;
import com.SUG.FLORA.interfaces.DTOEnum;

import lombok.Data;

@Data
public class EnumStatusDTO implements DTOEnum{
    private String status;

    public EnumStatusUsuario getModel() {
        return EnumStatusUsuario.valueOf(status);
    }
}
