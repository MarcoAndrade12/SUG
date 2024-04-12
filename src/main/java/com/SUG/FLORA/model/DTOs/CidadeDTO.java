package com.SUG.FLORA.model.DTOs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.MultiValueMap;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.IntDomain;
import com.SUG.FLORA.model.endereco.Cidade;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CidadeDTO extends IntDomainDTO implements DTO {

    private String nome;

    public CidadeDTO(MultiValueMap<String, String> body) {
		this.nome=body.getFirst("cidade");
	}

	@Override
    public Cidade getModel() {
        Cidade cidade = new Cidade();
        cidade.copyDomainOfIntDomainDTO(this);
        cidade.setNome(nome);

        return cidade;
    }

    @Override
    public void initByModel(Object obj) {

        if (obj instanceof Cidade) {
            Cidade cidade = (Cidade) obj;
            copyDomainOfIntDomain(cidade);

            this.nome = cidade.getNome();

        } else {
            throw new IllegalArgumentException("Esperava-se um objeto do tipo Cidade");
        }

    }

}
