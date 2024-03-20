package com.SUG.FLORA.model.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import com.SUG.FLORA.model.Domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class CEP extends Domain{

    @Column(nullable = false, unique = true)
    private String numero;
    
    @Column(nullable = true, unique = false)
    private String altitude;
    @Column(nullable = true, unique = false)
    private String longitude;

}
