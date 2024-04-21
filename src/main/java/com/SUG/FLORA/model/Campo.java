package com.SUG.FLORA.model;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Campo extends UuidDomain implements DTOConvertible {

    private String nome;
    private Endereco endereco;

    @Override
    public DTO getDTO() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDTO'");
    }

}
