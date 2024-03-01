package com.SUG.FLORA.model.endereco;

import com.SUG.FLORA.enums.EnumTipoLogradouro;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Logradouro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private EnumTipoLogradouro tipo;

    @Column(nullable = false, unique = false)
    private String nome;

    @ManyToOne
    @JoinColumn(name = "bairro_id", nullable = false, unique = false)
    private Bairro bairro;
    
    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false, unique = false)
    private Cidade cidade;
    
    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false, unique = false)
    private Estado estado;
    
    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false, unique = false)
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "cep_id", nullable = false, unique = false)
    private CEP cep;

    @Column(nullable = false, unique = false)
    private boolean isDeleted;
}
