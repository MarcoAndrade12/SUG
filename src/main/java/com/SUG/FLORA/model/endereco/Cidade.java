package com.SUG.FLORA.model.endereco;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false, unique = false)
    private Estado estado;

    @OneToMany
    @JoinTable(
        name = "cidade_ass_bairros",
        joinColumns = @JoinColumn(name="cidade_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "bairro_id", nullable = false)
    )
    private Set<Bairro> bairros;

    @OneToMany
    @JoinTable(
        name = "cidade_ass_logradouros",
        joinColumns = @JoinColumn(name="cidade_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "logradouro_id", nullable = false)
    )
    private Set<Logradouro> logradouros;

    @OneToMany
    @JoinTable(
        name = "cidade_ass_ceps",
        joinColumns = @JoinColumn(name="cidade_id", nullable = false),
        inverseJoinColumns = @JoinColumn(name = "cep_id", nullable = false)
    )
    private Set<CEP> ceps;

    @Column(nullable = false, unique = true)
    private boolean isDeleted;

}
