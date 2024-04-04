package com.SUG.FLORA.enums;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.interfaces.DTOEnumconvertible;
import com.SUG.FLORA.model.DTOs.EnumTipoLogradouroDTO;

public enum EnumTipoLogradouro implements DTOEnumconvertible {
    RUA,
    AVENIDA,
    TRAVESSA,
    ALAMEDA,
    ESTRADA,
    PRACA,
    RODOVIA,
    CAMINHO,
    VIA,
    OUTRO;

    @Override
    public EnumTipoLogradouroDTO getDTO() {
        EnumTipoLogradouroDTO dto = new EnumTipoLogradouroDTO();
        dto.setTipo(this.name());
        return dto;

    }
}
