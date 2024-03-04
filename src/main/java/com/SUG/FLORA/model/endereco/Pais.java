package com.SUG.FLORA.model.endereco;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    @Column(nullable = false, unique = false)
    private boolean isDeleted;
}
