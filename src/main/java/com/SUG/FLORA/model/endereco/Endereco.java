package com.SUG.FLORA.model.endereco;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, unique = false)
    private int numero_casa;

    @Column(nullable = true, unique = false)
    private String complemento;

    @ManyToOne
    @JoinColumn(name = "pais_id", nullable = false, unique = false)
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "estado_id", nullable = false, unique = false)
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "cidade_id", nullable = false, unique = false)
    private Cidade cidade;

    @ManyToOne
    @JoinColumn(name = "bairro_id", nullable = false, unique = false)
    private Bairro bairro;

    @ManyToOne
    @JoinColumn(name = "logradouro_id", nullable = false, unique = false)
    private Logradouro logradouro;

    @ManyToOne
    @JoinColumn(name = "cep_id", nullable = false, unique = false)
    private CEP cep;

    @Column(nullable = false, unique = false)
    private boolean isDeleted;
}
