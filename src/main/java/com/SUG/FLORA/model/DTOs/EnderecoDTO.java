package com.SUG.FLORA.model.DTOs;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.endereco.Endereco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EnderecoDTO extends IntDomainDTO implements DTO{

    private PaisDTO pais = new PaisDTO();
    private EstadoDTO estado = new EstadoDTO();
    private CidadeDTO cidade = new CidadeDTO();


    @Override
    public Endereco getModel() {
        Endereco endereco = new Endereco();
        setDomainModel(endereco);
        endereco.setPais(pais.getModel());
        endereco.setEstado(estado.getModel());
        endereco.setCidade(cidade.getModel());

        return endereco;

    }

}
