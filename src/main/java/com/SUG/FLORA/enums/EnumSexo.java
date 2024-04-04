package com.SUG.FLORA.enums;

import java.time.LocalDateTime;
import java.util.UUID;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.interfaces.DTOEnum;
import com.SUG.FLORA.interfaces.DTOEnumconvertible;
import com.SUG.FLORA.model.DTOs.EnumSexoDTO;

public enum EnumSexo implements DTOEnumconvertible{
    MASCULINO,
    FEMININO;

    @Override
    public DTOEnum getDTO() {
        EnumSexoDTO sexoDTO = new EnumSexoDTO();
        sexoDTO.setNome(this.name());
        return sexoDTO;
    }

}
