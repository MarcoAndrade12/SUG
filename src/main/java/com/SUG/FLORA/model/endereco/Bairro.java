package com.SUG.FLORA.model.endereco;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.SUG.FLORA.model.Domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
public class Bairro extends Domain{

    @Column(nullable = false, unique = false)
    private String nome;
    
    @OneToMany
    @JoinColumn(name = "bairro_id")
    private List<Logradouro> logradouros;

    @ManyToMany
    @JoinTable(
        name = "bairro_ass_cep",
        joinColumns = @JoinColumn(name="bairro_id"),
        inverseJoinColumns = @JoinColumn(name="cep_id")
    )
    private List<CEP> ceps;

}
