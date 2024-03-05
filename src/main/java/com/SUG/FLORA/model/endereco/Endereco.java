package com.SUG.FLORA.model.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.SUG.FLORA.model.Domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Endereco extends Domain{

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
}
