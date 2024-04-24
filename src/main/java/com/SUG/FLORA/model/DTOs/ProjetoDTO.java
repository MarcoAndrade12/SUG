package com.SUG.FLORA.model.DTOs;

import java.util.ArrayList;
import java.util.List;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.Projeto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProjetoDTO extends UuidDomainDTO implements DTO {

    private String nome;
    private String descricao;
    private List<CampoDTO> campos = new ArrayList<>();
    private List<ColetaDTO> coletas = new ArrayList<>();

    @Override
    public Projeto getModel() {
        Projeto projeto = new Projeto();
        projeto.copyDomainOfUuidDomainDTO(this);
        projeto.setNome(nome);
        projeto.setDescricao(descricao);
        projeto.setCampos(campos.stream().map(campo -> campo.getModel()).toList());

        return projeto;
    }

    @Override
    public void initByModel(Object dtoConvertible) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'initByModel'");
    }

}
