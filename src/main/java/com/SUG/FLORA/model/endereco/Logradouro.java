package com.SUG.FLORA.model.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import com.SUG.FLORA.enums.EnumTipoLogradouro;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.IntDomain;
import com.SUG.FLORA.model.UuidDomain;
import com.SUG.FLORA.model.DTOs.EnumTipoLogradouroDTO;
import com.SUG.FLORA.model.DTOs.LogradouroDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Logradouro extends IntDomain implements DTOConvertible {

    @Enumerated(EnumType.STRING)
    private EnumTipoLogradouro tipo;

    @Column(nullable = false, unique = false)
    private String nome;

    @OneToOne
    @JoinColumn(name = "cep_id", nullable = false, unique = false)
    private CEP cep = new CEP();

    @Override
    public LogradouroDTO getDTO() {
        LogradouroDTO DTO = new LogradouroDTO();
        DTO.setId(getId());
        DTO.setCreationDate(getCreationDate());
        DTO.setDeleted(isDeleted());
        DTO.setDeletedDate(getDeletedDate());

        EnumTipoLogradouroDTO tipo = new EnumTipoLogradouroDTO();
        tipo.setTipo(tipo.getTipo());

        DTO.setTipo(tipo);
        DTO.setNome(nome);
        DTO.setCep(cep.getDTO());

        return DTO;
    }
}
