package com.SUG.FLORA.model.endereco;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.SUG.FLORA.model.Domain;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pais extends Domain{

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = true)
    private String sigla;

    @OneToMany
    @JoinTable(
        name = "pais_ass_regioes",
        joinColumns = @JoinColumn(name="pais_id"),
        inverseJoinColumns = @JoinColumn(name="regiao_id")
    )
    private List<RegiaoDoPais> regioes;
    
    @OneToMany
    @JoinColumn(name = "pais_id")
    private List<Estado> estados;
}
