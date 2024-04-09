package com.SUG.FLORA.enums;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.interfaces.DTOEnumconvertible;
import com.SUG.FLORA.model.DTOs.EnumStatusDTO;

public enum EnumStatusUsuario implements DTOEnumconvertible{
    ATIVO,
    INATIVO,
    DELETADO;

    @Override
    public EnumStatusDTO getDTO() {
		EnumStatusDTO DTO = new EnumStatusDTO();
        DTO.setName(this.toString());
        return DTO;
    }
}
