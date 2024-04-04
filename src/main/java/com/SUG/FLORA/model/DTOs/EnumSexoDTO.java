package com.SUG.FLORA.model.DTOs;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.interfaces.DTOEnum;

import lombok.Data;

@Data
public class EnumSexoDTO implements DTOEnum{
    private String nome;

    public EnumSexo getModel() {
        return EnumSexo.valueOf(nome);
    }
}
