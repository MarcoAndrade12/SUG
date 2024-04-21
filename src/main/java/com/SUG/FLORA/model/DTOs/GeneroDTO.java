package com.SUG.FLORA.model.DTOs;

import java.util.ArrayList;
import java.util.List;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.model.Genero;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class GeneroDTO extends IntDomainDTO implements DTO {

    private String nome_cientifico;
    private List<EspecieDTO> especies = new ArrayList<>();

    @Override
    public Genero getModel() {
        Genero genero = new Genero();
        genero.copyDomainOfIntDomainDTO(this);
        genero.setNome_cientifico(nome_cientifico);
        genero.setEspecies(especies.stream().map(especie -> especie.getModel()).toList());
        return genero;
    }

    @Override
    public void initByModel(Object obj) {

        if (obj instanceof Genero) {
            Genero genero = (Genero) obj;
            copyDomainOfIntDomain(genero);

            this.nome_cientifico = genero.getNome_cientifico();
            this.especies = genero.getEspeciesDTO();

        } else {
            throw new IllegalArgumentException("Esperava-se um objeto do tipo Genero");
        }

    }

}
