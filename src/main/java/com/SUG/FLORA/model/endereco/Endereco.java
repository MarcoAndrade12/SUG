package com.SUG.FLORA.model.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.SUG.FLORA.model.Domain;
import com.SUG.FLORA.model.DTOs.EnderecoDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Endereco extends Domain{

    @Column(nullable = false, unique = false)
    private int numero_casa;

    @Column(nullable = true, unique = false)
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false, unique = false)
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false, unique = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false, unique = false)
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "bairro_id", nullable = false, unique = false)
    private Bairro bairro;

    @ManyToOne
    @JoinColumn(name = "logradouro_id", nullable = false, unique = false)
    private Logradouro logradouro;

    @ManyToOne
    @JoinColumn(name = "cep_id", nullable = false, unique = false)
    private CEP cep;

    public EnderecoDTO getDTO() {
        EnderecoDTO DTO = new EnderecoDTO();
        DTO.setId(getId());
		DTO.setCreationDate(getCreationDate());
		DTO.setDeleted(isDeleted());
		DTO.setDeletedDate(getDeletedDate());

        DTO.setNumero_casa(numero_casa);
        DTO.setComplemento(complemento);
        DTO.setPais(pais.getDTO());
        DTO.setEstado(estado.getDTO());
        DTO.setCidade(cidade.getDTO());
        DTO.setBairro(bairro.getDTO());
        DTO.setLogradouro(logradouro.getDTO());
        DTO.setCep(cep.getDTO());

        return DTO;
    }
}
