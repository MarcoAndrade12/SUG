package com.SUG.FLORA.model.DTOs;

import java.util.ArrayList;
import java.util.List;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.endereco.Estado;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class EstadoDTO extends IntDomainDTO implements DTO {

    private String nome;
    private String sigla;
    private List<CidadeDTO> cidades = new ArrayList<CidadeDTO>();

    @Override
    public Estado getModel() {
        Estado estado = new Estado();
        setDomainModel(estado);
        estado.setNome(nome);
        estado.setSigla(sigla);
        estado.setCidades(cidades.stream().map(cidade -> cidade.getModel()).toList());

        return estado;
    }

}
