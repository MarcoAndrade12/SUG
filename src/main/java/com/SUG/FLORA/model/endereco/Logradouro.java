package com.SUG.FLORA.model.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import com.SUG.FLORA.enums.EnumTipoLogradouro;
import com.SUG.FLORA.model.Domain;
import com.SUG.FLORA.model.DTOs.LogradouroDTO;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Logradouro extends Domain{

    @Enumerated(EnumType.STRING)
    private EnumTipoLogradouro tipo;

    @Column(nullable = false, unique = false)
    private String nome;

    @OneToOne
    @JoinColumn(name = "cep_id", nullable = false, unique = false)
    private CEP cep;

    public LogradouroDTO getDTO() {
        LogradouroDTO DTO = new LogradouroDTO();
        DTO.setId(getId());
		DTO.setCreationDate(getCreationDate());
		DTO.setDeleted(isDeleted());
		DTO.setDeletedDate(getDeletedDate());

        DTO.setTipo(tipo);
        DTO.setNome(nome);
        DTO.setCep(cep.getDTO());
        
        return DTO;
    }
}
