package com.SUG.FLORA.model.endereco;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = true, length = 5)
    private String sigla;

    @ManyToOne
    @JoinColumn(name = "regiaoPais_id", nullable = false, unique = false)
    private RegiaoDoPais regiaoDoPais;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false, unique = false)
    private Pais pais;

    @OneToMany
    @JoinTable(
        name = "estado_ass_cidades",
        joinColumns = @JoinColumn(name="estado_id"),
        inverseJoinColumns = @JoinColumn(name="cidade_id")
    )
    private Set<Cidade> cidades;

    @OneToMany
    @JoinTable(
        name = "estado_ass_bairros",
        joinColumns = @JoinColumn(name="estado_id"),
        inverseJoinColumns = @JoinColumn(name="bairro_id")
    )
    private Set<Bairro> bairros;

    @OneToMany
    @JoinTable(
        name = "estado_ass_logradouros",
        joinColumns = @JoinColumn(name="estado_id"),
        inverseJoinColumns = @JoinColumn(name="logradouro_id")
    )
    private Set<Logradouro> logradouros;

    @OneToMany
    @JoinTable(
        name = "estado_ass_ceps",
        joinColumns = @JoinColumn(name="estado_id"),
        inverseJoinColumns = @JoinColumn(name="cep_id")
    )
    private Set<CEP> ceps;

    @Column(nullable = false, unique = false)
    private boolean isDeleted;

}
