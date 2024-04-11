package com.SUG.FLORA.model.DTOs;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.MultiValueMap;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.endereco.Pais;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaisDTO extends IntDomainDTO implements DTO {

    private String nome;
    private String sigla;
    private List<RegiaoDoPaisDTO> regioes = new ArrayList<RegiaoDoPaisDTO>();
    private List<EstadoDTO> estados = new ArrayList<EstadoDTO>();

    public PaisDTO(MultiValueMap<String, String> body) {
        this.nome = body.getFirst("pais");
    }

    @Override
    public Pais getModel() {
        Pais pais = new Pais();

        setDomainModel(pais);

        pais.setNome(nome);
        pais.setSigla(sigla);
        pais.setRegioes(regioes.stream().map(regiao -> regiao.getModel()).toList());
        pais.setEstados(estados.stream().map(estado -> estado.getModel()).toList());

        return pais;
    }

}
