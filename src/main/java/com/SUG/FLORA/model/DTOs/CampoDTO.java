package com.SUG.FLORA.model.DTOs;

import java.util.ArrayList;
import java.util.List;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.Campo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class CampoDTO extends UuidDomainDTO implements DTO {

    private String nome;
    private String descricao;
    private EnderecoDTO enderecoDTO;
    private List<ColetaDTO> coletas = new ArrayList<>();

    @Override
    public Campo getModel() {

        Campo campo = new Campo();
        campo.copyDomainOfUuidDomainDTO(this);
        campo.setNome(nome);
        campo.setDescricao(descricao);
        campo.setEndereco(enderecoDTO.getModel());

        return campo;
    }

    @Override
    public void initByModel(Object dtoConvertible) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initByModel'");
    }

}
