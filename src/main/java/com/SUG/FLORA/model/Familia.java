package com.SUG.FLORA.model;

import java.util.List;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.DTOs.FamiliaDTO;
import com.SUG.FLORA.model.DTOs.GeneroDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Familia extends IntDomain implements DTOConvertible {

    @Column(nullable = false, unique = true)
    private String nome_cientifico;

    @OneToMany
    @JoinColumn(name = "familia_id")
    private List<Genero> generos;

    @Override
    public FamiliaDTO getDTO() {
        FamiliaDTO familiaDTO = new FamiliaDTO();
        familiaDTO.copyDomainOfIntDomain(this);
        familiaDTO.setNome_cientifico(nome_cientifico);
        familiaDTO.setGeneros(getGenerosDTO());

        return familiaDTO;
    }

    public List<GeneroDTO> getGenerosDTO() {
        return generos.stream().map(genero -> genero.getDTO()).toList();
    }

}
