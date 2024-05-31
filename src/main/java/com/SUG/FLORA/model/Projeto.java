package com.SUG.FLORA.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.SUG.FLORA.interfaces.DTO;
import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.DTOs.CampoDTO;
import com.SUG.FLORA.model.DTOs.ColetaDTO;
import com.SUG.FLORA.model.DTOs.ProjetoDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Projeto extends UuidDomain implements DTOConvertible {

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuarioDono;

    private String nome;
    private String descricao;

    @ManyToMany
    @JoinTable(name = "projeto_usuario", joinColumns = @JoinColumn(name = "projeto_id"), inverseJoinColumns = @JoinColumn(name = "usuario_id"))
    private List<Usuario> usuarios = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "projeto_campo", joinColumns = @JoinColumn(name = "projeto_id"), inverseJoinColumns = @JoinColumn(name = "campo_id"))
    private List<Campo> campos = new ArrayList<>();

    @OneToMany
    @JoinColumn(name = "projeto_id")
    private List<Coleta> coletas = new ArrayList<>();

    private boolean ativo = true;

    @Override
    public ProjetoDTO getDTO() {
        ProjetoDTO projetoDTO = new ProjetoDTO();
        projetoDTO.copyDomainOfUuidDomain(this);
        projetoDTO.setNome(nome);
        projetoDTO.setDescricao(descricao);
        projetoDTO.setCampos(getCamposDTO());
        projetoDTO.setColetas(getColetasDTO());
        projetoDTO.setAtivo(ativo);

        return projetoDTO;
    }

    public List<CampoDTO> getCamposDTO() {
        return campos.stream().map(campo -> campo.getDTO()).toList();
    }

    public List<ColetaDTO> getColetasDTO() {
        return coletas.stream().map(coleta -> coleta.getDTO()).toList();
    }

}
