package com.SUG.FLORA.model.endereco;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = false)
    private String nome;
    
    @OneToMany(mappedBy = "bairro")
    private Set<Logradouro> logradouros;

    @ManyToMany
    @JoinTable(
        name = "bairro_ass_cep",
        joinColumns = @JoinColumn(name="bairro_id"),
        inverseJoinColumns = @JoinColumn(name="cep_id")
    )
    private Set<CEP> ceps;
    
    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false, unique = false)
    private Cidade cidade;
    
    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false, unique = false)
    private Estado estado;
    
    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false, unique = false)
    private Pais pais;

    @Column(nullable = false, unique = false)
    private boolean isDeleted;
}
