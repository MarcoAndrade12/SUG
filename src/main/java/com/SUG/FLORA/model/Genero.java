package com.SUG.FLORA.model;

import java.util.ArrayList;
import java.util.List;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.DTOs.EspecieDTO;
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
public class Genero extends IntDomain implements DTOConvertible {

    @Column(nullable = false, unique = true)
    private String nome_cientifico;

    @OneToMany
    @JoinColumn(name = "genero_id")
    private List<Especie> especies = new ArrayList<>();

    @Override
    public GeneroDTO getDTO() {

        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.copyDomainOfIntDomain(this);
        generoDTO.setNome_cientifico(nome_cientifico);
        generoDTO.setEspecies(getEspeciesDTO());

        return generoDTO;
    }

    public List<EspecieDTO> getEspeciesDTO() {
        return this.especies.stream().map(especies -> especies.getDTO()).toList();
    }

}
