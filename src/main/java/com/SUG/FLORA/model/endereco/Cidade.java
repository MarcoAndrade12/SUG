package com.SUG.FLORA.model.endereco;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.Domain;
import com.SUG.FLORA.model.DTOs.CidadeDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Cidade extends Domain implements DTOConvertible {

    @Column(nullable = false, unique = false)
    private String nome;

    @OneToMany
    @JoinColumn(name = "cidade_id")
    private List<Bairro> bairros;

    @Override
    public CidadeDTO getDTO() {
        CidadeDTO DTO = new CidadeDTO();
        DTO.setId(getId());
        DTO.setCreationDate(getCreationDate());
        DTO.setDeleted(isDeleted());
        DTO.setDeletedDate(getDeletedDate());

        DTO.setNome(nome);
        DTO.setBairros(bairros.stream().map(bairro -> bairro.getDTO()).toList());

        return DTO;
    }

}
