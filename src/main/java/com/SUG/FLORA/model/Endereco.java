package com.SUG.FLORA.model;

import jakarta.persistence.Entity;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.DTOs.EnderecoDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
public class Endereco extends IntDomain implements DTOConvertible {

    // @ManyToOne
    // @JoinColumn(name = "pais_id", nullable = true, unique = false)
    // private Pais pais = new Pais();
    //
    // @ManyToOne
    // @JoinColumn(name = "estado_id", nullable = true, unique = false)
    // private Estado estado = new Estado();
    //
    // @ManyToOne
    // @JoinColumn(name = "cidade_id", nullable = true, unique = false)
    // private Cidade cidade = new Cidade();

    private String pais;
    private String estado;
    private String cidade;

    public EnderecoDTO getDTO() {
        EnderecoDTO DTO = new EnderecoDTO();
        DTO.setId(getId());
        DTO.setCreationDate(getCreationDate());
        DTO.setDeleted(isDeleted());
        DTO.setDeletedDate(getDeletedDate());

        // DTO.setPais(pais.getDTO());
        // DTO.setEstado(estado.getDTO());
        // DTO.setCidade(cidade.getDTO());

        return DTO;
    }
}
