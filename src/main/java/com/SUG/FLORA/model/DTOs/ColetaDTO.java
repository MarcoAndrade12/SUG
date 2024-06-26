package com.SUG.FLORA.model.DTOs;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.Coleta;
import com.SUG.FLORA.model.Especie;
import com.SUG.FLORA.model.Familia;
import com.SUG.FLORA.model.Genero;
import com.SUG.FLORA.services.CampoService;
import com.SUG.FLORA.services.ColetaService;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ColetaDTO extends UuidDomainDTO implements DTO {

    @Autowired
    CampoService campoService;

    private int codigoId;
    private LocalDate data_coleta;
    private FamiliaDTO familia;
    private GeneroDTO genero;
    private EspecieDTO especie;
    private CampoDTO campo;

    public boolean identificada() {
        if (familia != null & genero != null & especie != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Coleta getModel() {
        Coleta coleta = new Coleta();
        coleta.copyDomainOfUuidDomainDTO(this);
        coleta.setCodigoId(codigoId);
        coleta.setData_coleta(data_coleta);
        coleta.setFamilia(familia.getModel());
        coleta.setGenero(genero.getModel());
        coleta.setEspecie(especie.getModel());
        coleta.setCampo(campo.getModel());
        return coleta;

    }

    @Override
    public void initByModel(Object dtoConvertible) {

        if (dtoConvertible instanceof Coleta) {
            Coleta obj = (Coleta) dtoConvertible;
            copyDomainOfUuidDomain(obj);
            setCodigoId(obj.getCodigoId());
            setData_coleta(obj.getData_coleta());
            setFamilia(obj.getFamilia().getDTO());
            setGenero(obj.getGenero().getDTO());
            setEspecie(obj.getEspecie().getDTO());
        } else {
            throw new IllegalArgumentException("Esperava-se um objeto do tipo Coleta");
        }

    }

    public String getNomeEspecie(){
        return familia.getNome_cientifico() + " " + genero.getNome_cientifico() + " " + especie.getNome_cientifico();
    }

    public String isIdentificada(){
        if (identificada()) {
            return "IDENTIFICADA";
        } else {
            return "NÃO IDENTIFICADA";
        }
    }

}
