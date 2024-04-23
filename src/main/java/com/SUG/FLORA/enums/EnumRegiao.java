package com.SUG.FLORA.enums;

import java.time.LocalDateTime;
import java.util.UUID;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.interfaces.DTOEnum;
import com.SUG.FLORA.interfaces.DTOEnumconvertible;

public enum EnumRegiao implements DTOEnumconvertible{
    NORTE,
    SUL,
    LESTE,
    OESTE,
    NORDESTE,
    SUDESTE,
    NOROESTE,
    CENTROESTE,
    CENTROSUL,
    LESTENORDESTE;

    @Override
    public DTOEnum getDTO() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDTO'");
    }

}
