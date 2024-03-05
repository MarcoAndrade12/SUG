package com.SUG.FLORA.model.endereco;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.SUG.FLORA.model.Domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Cidade extends Domain{

    @Column(nullable = false, unique = false)
    private String nome;

    @OneToMany
    @JoinColumn(name="cidade_id")
    private List<Bairro> bairros;

}
