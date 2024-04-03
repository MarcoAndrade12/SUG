package com.SUG.FLORA.model.DTOs;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.model.endereco.CEP;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class cepDTO extends DomainDTO implements DTO{

    private String numero;
    private String altitude;
    private String longitude;

    @Override
    public CEP getModel() {
        CEP cep = new CEP();
        cep.setId(getId());
        cep.setCreationDate(getCreationDate());
        cep.setDeleted(isDeleted());
        cep.setDeletedDate(getDeletedDate());
        cep.setLastUpdate(getLastUpdate());
        cep.setNumero(numero);
        cep.setAltitude(altitude);
        cep.setLongitude(longitude);
 
        return cep;
    }

}
