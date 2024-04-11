package com.SUG.FLORA.model.endereco;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.IntDomain;
import com.SUG.FLORA.model.UuidDomain;
import com.SUG.FLORA.model.DTOs.CidadeDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Cidade extends IntDomain implements DTOConvertible {

    @Column(nullable = true, unique = false)
    private String nome;

    @Override
    public CidadeDTO getDTO() {
        CidadeDTO DTO = new CidadeDTO();
        DTO.setId(getId());
        DTO.setCreationDate(getCreationDate());
        DTO.setDeleted(isDeleted());
        DTO.setDeletedDate(getDeletedDate());

        DTO.setNome(nome);

        return DTO;
    }

}
