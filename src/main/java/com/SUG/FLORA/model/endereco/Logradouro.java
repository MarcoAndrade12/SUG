package com.SUG.FLORA.model.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.SUG.FLORA.enums.EnumTipoLogradouro;
import com.SUG.FLORA.model.Domain;

import lombok.Getter;
import lombok.Setter;
@Entity
@Getter
@Setter
public class Logradouro extends Domain{

    @Enumerated(EnumType.STRING)
    private EnumTipoLogradouro tipo;

    @Column(nullable = false, unique = false)
    private String nome;

    @OneToOne
    @JoinColumn(name = "cep_id", nullable = false, unique = false)
    private CEP cep;
}
