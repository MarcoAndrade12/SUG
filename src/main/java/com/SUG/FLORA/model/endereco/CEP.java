package com.SUG.FLORA.model.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.Domain;
import com.SUG.FLORA.model.DTOs.cepDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class CEP extends Domain implements DTOConvertible{

    @Column(nullable = false, unique = true)
    private String numero;
    
    @Column(nullable = true, unique = false)
    private String altitude;
    @Column(nullable = true, unique = false)
    private String longitude;

    public cepDTO getDTO() {
        cepDTO DTO = new cepDTO();
        DTO.setId(getId());
		DTO.setCreationDate(getCreationDate());
		DTO.setDeleted(isDeleted());
		DTO.setDeletedDate(getDeletedDate());

        DTO.setNumero(numero);
        DTO.setAltitude(altitude);
        DTO.setLongitude(longitude);

        return DTO;
    }

}
