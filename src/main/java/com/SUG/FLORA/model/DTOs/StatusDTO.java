package com.SUG.FLORA.model.DTOs;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.enums.EnumStatusUsuario;
import com.SUG.FLORA.interfaces.DTO;

import lombok.Data;

@Data
public class StatusDTO implements DTO{
    private String status;

    public EnumStatusUsuario getModel() {
        return EnumStatusUsuario.valueOf(status);
    }
}
