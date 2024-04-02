package com.SUG.FLORA.model.endereco;

import java.util.List;

import jakarta.persistence.*;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.Domain;
import com.SUG.FLORA.model.DTOs.BairroDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Bairro extends Domain implements DTOConvertible {

    @Column(nullable = false, unique = false)
    private String nome;

    @OneToMany
    @JoinColumn(name = "bairro_id")
    private List<Logradouro> logradouros;

    @ManyToMany
    @JoinTable(name = "bairro_ass_cep", joinColumns = @JoinColumn(name = "bairro_id"), inverseJoinColumns = @JoinColumn(name = "cep_id"))
    private List<CEP> ceps;

    @Override
    public BairroDTO getDTO() {
        BairroDTO DTO = new BairroDTO();
        DTO.setId(getId());
        DTO.setCreationDate(getCreationDate());
        DTO.setDeleted(isDeleted());
        DTO.setDeletedDate(getDeletedDate());

        DTO.setNome(nome);
        DTO.setLogradourosDTOs(logradouros.stream().map(log -> log.getDTO()).toList());
        DTO.setCepsDTOs(ceps.stream().map(cep -> cep.getDTO()).toList());

        return DTO;
    }

}
