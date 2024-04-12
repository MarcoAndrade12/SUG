package com.SUG.FLORA.model.endereco;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.IntDomain;
import com.SUG.FLORA.model.DTOs.EstadoDTO;
import com.SUG.FLORA.model.DTOs.PaisDTO;
import com.SUG.FLORA.model.DTOs.RegiaoDoPaisDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pais extends IntDomain implements DTOConvertible {

    @Column(nullable = true, unique = true)
    private String nome;

    @Column(nullable = true, unique = true)
    private String sigla;

    @OneToMany
    @JoinTable(name = "pais_ass_regioes", joinColumns = @JoinColumn(name = "pais_id"), inverseJoinColumns = @JoinColumn(name = "regiao_id"))
    private List<RegiaoDoPais> regioes = new ArrayList<RegiaoDoPais>();

    @OneToMany
    @JoinColumn(name = "pais_id")
    private List<Estado> estados = new ArrayList<Estado>();

    @Override
    public PaisDTO getDTO() {
        PaisDTO DTO = new PaisDTO();
        DTO.setId(getId());
        DTO.setCreationDate(getCreationDate());
        DTO.setDeleted(isDeleted());
        DTO.setDeletedDate(getDeletedDate());

        DTO.setNome(nome);
        DTO.setSigla(sigla);
        DTO.setRegioes(getRegioesDTO());
        DTO.setEstados(getEstadosDTO());

        return DTO;
    }

    public List<RegiaoDoPaisDTO> getRegioesDTO() {
        return regioes.stream().map(regiao -> regiao.getDTO()).toList();
    }

    public List<EstadoDTO> getEstadosDTO() {
        return estados.stream().map(estado -> estado.getDTO()).toList();
    }
}
