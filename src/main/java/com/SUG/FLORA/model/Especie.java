package com.SUG.FLORA.model;

import java.util.ArrayList;
import java.util.List;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.DTOs.EspecieDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Especie extends IntDomain implements DTOConvertible {
    
    @Column(nullable = false, unique = true)
    private String nome_cientifico;

    //@OneToMany
    //@JoinColumn(name = "especie_id")
    private List<String> nome_comum = new ArrayList<String>();

    @Column(nullable = true, unique = false)
    private String autor;   
    
    
    @Override
    public EspecieDTO getDTO() {
        EspecieDTO especieDTO = new EspecieDTO();
        especieDTO.copyDomainOfIntDomain(this);

        especieDTO.setNome_cientifico(nome_cientifico);
        especieDTO.setNome_comum(nome_comum);
        especieDTO.setAutor(autor);

        return especieDTO;
    }
    
}
