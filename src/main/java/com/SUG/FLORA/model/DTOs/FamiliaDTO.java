package com.SUG.FLORA.model.DTOs;

import java.util.ArrayList;
import java.util.List;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.Familia;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class FamiliaDTO extends IntDomainDTO implements DTO {

    private String nome_cientifico;
    private List<GeneroDTO> generos = new ArrayList<>();

    @Override
    public Familia getModel() {
        Familia familia = new Familia();
        familia.copyDomainOfIntDomainDTO(this);

        familia.setNome_cientifico(nome_cientifico);
        familia.setGeneros(generos.stream().map(genero -> genero.getModel()).toList());

        return familia;
    }

    @Override
    public void initByModel(Object obj) {

        if (obj instanceof Familia) {
            Familia familia = (Familia) obj;
            copyDomainOfIntDomain(familia);
            this.nome_cientifico = familia.getNome_cientifico();
            this.generos = familia.getGenerosDTO();

        } else {
            throw new IllegalArgumentException("Esperava-se um objeto do tipo Familia");
        }

    }

}
