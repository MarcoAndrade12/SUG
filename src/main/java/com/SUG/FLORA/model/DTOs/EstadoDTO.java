package com.SUG.FLORA.model.DTOs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.MultiValueMap;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.endereco.Estado;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
public class EstadoDTO extends IntDomainDTO implements DTO {

    private String nome;
    private String sigla;
    private List<CidadeDTO> cidades = new ArrayList<CidadeDTO>();

    @Override
    public Estado getModel() {
        Estado estado = new Estado();
        estado.copyDomainOfIntDomainDTO(this);
        estado.setNome(nome);
        estado.setSigla(sigla);
        estado.setCidades(cidades.stream().map(cidade -> cidade.getModel()).toList());

        return estado;
    }

	public EstadoDTO(MultiValueMap<String, String> body) {
		this.nome = body.getFirst("estado");
	}

}
