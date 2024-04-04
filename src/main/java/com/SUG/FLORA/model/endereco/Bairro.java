package com.SUG.FLORA.model.endereco;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.*;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.IntDomain;
import com.SUG.FLORA.model.UuidDomain;
import com.SUG.FLORA.model.DTOs.BairroDTO;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Bairro extends IntDomain implements DTOConvertible {

    @Column(nullable = false, unique = false)
    private String nome;

    @OneToMany
    @JoinColumn(name = "bairro_id")
    private List<Logradouro> logradouros = new ArrayList<Logradouro>();

    @ManyToMany
    @JoinTable(name = "bairro_ass_cep", joinColumns = @JoinColumn(name = "bairro_id"), inverseJoinColumns = @JoinColumn(name = "cep_id"))
    private List<CEP> ceps = new ArrayList<CEP>();

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
