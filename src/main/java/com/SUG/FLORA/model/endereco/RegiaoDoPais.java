package com.SUG.FLORA.model.endereco;

import java.util.Set;

import com.SUG.FLORA.enums.EnumRegiao;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;

public class RegiaoDoPais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Enumerated(EnumType.STRING)
    private EnumRegiao nome;

    @ManyToOne
    @JoinTable(
        name = "regiao_ass_pais",
        joinColumns = @JoinColumn(name="regiao_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name="pais_id", nullable = false)
    )
    private Set<Pais> pais;

    @ManyToOne
    @JoinTable(
        name = "regiao_ass_estados",
        joinColumns = @JoinColumn(name="regiao_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name="estado_id", nullable = false)
    )
    private Set<Estado> estados;

    @Column(nullable = false, unique = false)
    private boolean isDeleted;

}
