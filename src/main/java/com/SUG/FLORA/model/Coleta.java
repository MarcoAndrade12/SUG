package com.SUG.FLORA.model;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.DTOs.ColetaDTO;
import com.SUG.FLORA.services.CampoService;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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

    private int codigoId;

    @ManyToOne
    @JoinColumn(name = "familia_id")
    private Familia familia;

    @ManyToOne
    @JoinColumn(name = "genero_id")
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "especie_id")
    private Especie especie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="campo_id")
    private Campo campo;

    @Override
    public ColetaDTO getDTO() {

        ColetaDTO coletaDTO = new ColetaDTO();
        coletaDTO.copyDomainOfUuidDomain(this);
        coletaDTO.setCodigoId(codigoId);
        coletaDTO.setData_coleta(data_coleta);
        coletaDTO.setFamilia(familia.getDTO());
        coletaDTO.setGenero(genero.getDTO());
        coletaDTO.setEspecie(especie.getDTO());
        coletaDTO.setCampo(getCampo().getDTO());


        return coletaDTO;
    }

}
