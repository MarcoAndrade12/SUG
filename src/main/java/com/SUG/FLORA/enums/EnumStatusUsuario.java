package com.SUG.FLORA.enums;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.interfaces.DTOEnumconvertible;

public enum EnumStatusUsuario {
    ATIVO,
    INATIVO,
    DELETADO;

    public static EnumStatusUsuario stringToEnum(String status) {

        switch (status.toUpperCase()) {
            case "ATIVO":
                return ATIVO;
            case "INATIVO":
                return INATIVO;
            case "DELETADO":
                return DELETADO;

            default:
                return ATIVO;
        }
    }

}
