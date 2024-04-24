package com.SUG.FLORA.model;

import java.time.LocalDate;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.DTOs.ColetaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Coleta extends UuidDomain implements DTOConvertible {

    @Column(nullable = false, unique = false)
    private LocalDate data_coleta;

    @ManyToOne
    @JoinColumn(name = "familia_id")
    private Familia familia;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "especie_id")
    private Especie especie;

    @Override
    public ColetaDTO getDTO() {

        ColetaDTO coletaDTO = new ColetaDTO();
        coletaDTO.copyDomainOfUuidDomain(this);

        coletaDTO.setData_coleta(data_coleta);
        coletaDTO.setFamilia(familia.getDTO());
        coletaDTO.setGenero(genero.getDTO());
        coletaDTO.setEspecie(especie.getDTO());

        return coletaDTO;
    }

}
