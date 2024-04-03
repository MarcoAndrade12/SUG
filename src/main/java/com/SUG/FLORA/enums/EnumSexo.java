package com.SUG.FLORA.enums;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.DTOs.SexoDTO;

public enum EnumSexo implements DTOConvertible{
    MASCULINO,
    FEMININO;

    @Override
    public DTO getDTO() {
        SexoDTO sexoDTO = new SexoDTO();
        sexoDTO.setNome(this.name());
        return sexoDTO;
    }
}
