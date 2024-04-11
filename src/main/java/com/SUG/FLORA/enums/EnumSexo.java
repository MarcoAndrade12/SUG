package com.SUG.FLORA.enums;

import java.time.LocalDateTime;
import java.util.UUID;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.interfaces.DTOEnum;
import com.SUG.FLORA.interfaces.DTOEnumconvertible;

public enum EnumSexo {
    MASCULINO,
    FEMININO,
    INDEFINIDO;

public static EnumSexo stringToSexo(String sexo){
    switch(sexo.toLowerCase()){
        case "masculino":
            return MASCULINO;
        case "feminino":
            return FEMININO;
        default:
            return INDEFINIDO;
    }
}

}
