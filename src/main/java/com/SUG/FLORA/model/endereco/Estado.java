package com.SUG.FLORA.model.endereco;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.SUG.FLORA.model.Domain;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Estado extends Domain{

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false, unique = true, length = 5)
    private String sigla;

    @OneToMany
    @JoinColumn(name = "estado_id")
    private List<Cidade> cidades;

}
