package com.SUG.FLORA.model.DTOs;

import org.springframework.util.MultiValueMap;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.endereco.Endereco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoDTO extends IntDomainDTO implements DTO{

    private PaisDTO pais = new PaisDTO();
    private EstadoDTO estado = new EstadoDTO();
    private CidadeDTO cidade = new CidadeDTO();


    public EnderecoDTO(MultiValueMap<String, String> body) {

        this.pais = new PaisDTO(body);

        // TODO: Parei aqui

        this.estado = new EstadoDTO(body);
        this.cidade = new CidadeDTO(body);

    }


    @Override
    public Endereco getModel() {
        Endereco endereco = new Endereco();
        endereco.copyDomainOfIntDomainDTO(this);
        endereco.setPais(pais.getModel());
        endereco.setEstado(estado.getModel());
        endereco.setCidade(cidade.getModel());

        return endereco;

    }

}
