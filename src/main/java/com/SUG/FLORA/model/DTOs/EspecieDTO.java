package com.SUG.FLORA.model.DTOs;

import java.util.ArrayList;
import java.util.List;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.model.Especie;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class EspecieDTO extends IntDomainDTO implements DTO {

    private String nome_cientifico;

    private List<String> nome_comum = new ArrayList<String>();

    private String autor;  

    @Override
    public Especie getModel() {
        Especie especie = new Especie();
        especie.copyDomainOfIntDomainDTO(this);

        especie.setNome_cientifico(nome_cientifico);
        especie.setNome_comum(nome_comum);
        especie.setAutor(autor);

        return especie;
    }

    @Override
    public void initByModel(Object obj) {

        if (obj instanceof Especie) {
            Especie especie = (Especie) obj;
            copyDomainOfIntDomain(especie);

            this.nome_cientifico = especie.getNome_cientifico();
            this.nome_comum = especie.getNome_comum();
            this.autor = especie.getAutor();

        } else {
            throw new IllegalArgumentException("Esperava-se um objeto do tipo Especie");
        }

    }
    
}
