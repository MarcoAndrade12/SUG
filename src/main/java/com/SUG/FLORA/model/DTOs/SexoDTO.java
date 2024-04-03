package com.SUG.FLORA.model.DTOs;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.interfaces.DTO;

import lombok.Data;

@Data
public class SexoDTO implements DTO{
    private String nome;

    public EnumSexo getModel() {
        return EnumSexo.valueOf(nome);
    }
}
