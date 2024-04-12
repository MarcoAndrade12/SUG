package com.SUG.FLORA.model.DTOs;

import java.util.ArrayList;
import java.util.List;

import com.SUG.FLORA.enums.EnumRegiao;
import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.endereco.RegiaoDoPais;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegiaoDoPaisDTO extends IntDomainDTO implements DTO{
    private EnumRegiao nome;
    private List<EstadoDTO> estados = new ArrayList<EstadoDTO>();

    @Override
    public RegiaoDoPais getModel() {

        RegiaoDoPais regiaoDoPais = new RegiaoDoPais();
        regiaoDoPais.copyDomainOfIntDomainDTO(this);

        regiaoDoPais.setNome(nome);
        regiaoDoPais.setEstados(estados.stream().map(estado -> estado.getModel()).toList());

        return regiaoDoPais;
    }

    @Override
    public void initByModel(Object obj) {

        if (obj instanceof RegiaoDoPais) {
            RegiaoDoPais regiaoDoPais = (RegiaoDoPais) obj;
            copyDomainOfIntDomain(regiaoDoPais);

            this.nome = regiaoDoPais.getNome();
            this.estados = regiaoDoPais.getEstadosDTO();

        } else {
            throw new IllegalArgumentException("Esperava-se um objeto do tipo RegiaoDoPais");
        }

    }

}
