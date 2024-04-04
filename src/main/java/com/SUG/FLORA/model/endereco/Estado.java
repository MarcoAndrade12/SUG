package com.SUG.FLORA.model.endereco;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.IntDomain;
import com.SUG.FLORA.model.DTOs.EstadoDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Estado extends IntDomain implements DTOConvertible {

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = true, length = 5)
    private String sigla;

    @OneToMany
    @JoinColumn(name = "estado_id")
    private List<Cidade> cidades = new ArrayList<Cidade>();

    public EstadoDTO getDTO() {
        EstadoDTO DTO = new EstadoDTO();
        DTO.setId(getId());
        DTO.setCreationDate(getCreationDate());
        DTO.setDeleted(isDeleted());
        DTO.setDeletedDate(getDeletedDate());

        DTO.setNome(nome);
        DTO.setSigla(sigla);
        DTO.setCidades(cidades.stream().map(cidade -> cidade.getDTO()).toList());
        return DTO;
    }

}
