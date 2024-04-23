package com.SUG.FLORA.model.DTOs;

import java.time.LocalDate;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.Coleta;
import com.SUG.FLORA.model.Especie;
import com.SUG.FLORA.model.Familia;
import com.SUG.FLORA.model.Genero;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ColetaDTO extends UuidDomainDTO implements DTO {

    private LocalDate data_coleta;
    private FamiliaDTO familia;
    private GeneroDTO genero;
    private EspecieDTO especie;

    @Override
    public Coleta getModel() {
        Coleta coleta = new Coleta();
        coleta.copyDomainOfUuidDomainDTO(this);

        coleta.setData_coleta(data_coleta);
        coleta.setFamilia(familia.getModel());
        coleta.setGenero(genero.getModel());
        coleta.setEspecie(especie.getModel());
        return coleta;

    }

    @Override
    public void initByModel(Object dtoConvertible) {

        if (dtoConvertible instanceof Coleta) {
            Coleta obj = (Coleta) dtoConvertible;
            copyDomainOfUuidDomain(obj);
            setData_coleta(obj.getData_coleta());
            setFamilia(obj.getFamilia().getDTO());
            setGenero(obj.getGenero().getDTO());
            setEspecie(obj.getEspecie().getDTO());
        } else {
            throw new IllegalArgumentException("Esperava-se um objeto do tipo Coleta");
        }

    }

}