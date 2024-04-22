package com.SUG.FLORA.model;

import java.util.ArrayList;
import java.util.List;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.DTOs.CampoDTO;
import com.SUG.FLORA.model.DTOs.ProjetoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Projeto extends UuidDomain implements DTOConvertible {

    private String nome;
    private String descricao;

    @ManyToMany
    @JoinTable(name = "projeto_campo", joinColumns = @JoinColumn(name = "projeto_id"), inverseJoinColumns = @JoinColumn(name = "campo_id"))
    private List<Campo> campos = new ArrayList<>();

    @Override
    public ProjetoDTO getDTO() {
        ProjetoDTO projetoDTO = new ProjetoDTO();
        projetoDTO.copyDomainOfUuidDomain(this);
        projetoDTO.setNome(nome);
        projetoDTO.setDescricao(descricao);
        projetoDTO.setCampos(getCamposDTO());

        return projetoDTO;
    }

    public List<CampoDTO> getCamposDTO() {
        return campos.stream().map(campo -> campo.getDTO()).toList();
    }

}
