package com.SUG.FLORA.model.DTOs;

import org.springframework.util.MultiValueMap;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.model.Endereco;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EnderecoDTO extends IntDomainDTO implements DTO {

    private String pais;
    private String estado;
    private String cidade;

    public EnderecoDTO(MultiValueMap<String, String> body) {

        this.pais = body.getFirst("pais");
        this.estado = body.getFirst("estado");
        this.cidade = body.getFirst("cidade");

    }

    @Override
    public Endereco getModel() {
        Endereco endereco = new Endereco();
        endereco.copyDomainOfIntDomainDTO(this);
        endereco.setPais(pais);
        endereco.setEstado(estado);
        endereco.setCidade(cidade);

        return endereco;

    }

    @Override
    public void initByModel(Object obj) {

        if (obj instanceof Endereco) {
            Endereco endereco = (Endereco) obj;
            copyDomainOfIntDomain(endereco);

            this.pais = endereco.getPais();
            this.estado = endereco.getEstado();
            this.cidade = endereco.getCidade();

        } else {
            throw new IllegalArgumentException("Esperava-se um objeto do tipo Endereco");
        }

    }

}
