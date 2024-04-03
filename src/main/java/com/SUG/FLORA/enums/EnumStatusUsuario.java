package com.SUG.FLORA.enums;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.DTOs.StatusDTO;

public enum EnumStatusUsuario implements DTOConvertible{
    ATIVO,
    INATIVO,
    DELETADO;

    @Override
    public StatusDTO getDTO() {
		StatusDTO DTO = new StatusDTO();
        DTO.setStatus(this.name());
        return DTO;
    }
}
