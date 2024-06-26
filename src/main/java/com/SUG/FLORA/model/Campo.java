package com.SUG.FLORA.model;

import java.util.ArrayList;
import java.util.List;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.DTOs.CampoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Campo extends UuidDomain implements DTOConvertible {

    private String nome;
    private String descricao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "endereco_id", nullable = true, unique = false)
    private Endereco endereco;

    @OneToMany
    @JoinColumn(name = "campo_id")
    private List<Coleta> coletas = new ArrayList<>();

    @Override
    public CampoDTO getDTO() {

        CampoDTO campoDTO = new CampoDTO();
        campoDTO.copyDomainOfUuidDomain(this);
        campoDTO.setNome(nome);
        campoDTO.setDescricao(descricao);

        if (endereco != null) {
            campoDTO.setEnderecoDTO(endereco.getDTO());
        }

        return campoDTO;
    }

}
