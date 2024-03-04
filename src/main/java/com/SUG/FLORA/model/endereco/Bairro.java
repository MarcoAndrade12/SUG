package com.SUG.FLORA.model.endereco;

import java.util.List;
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
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
public class Bairro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

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

    @Column(nullable = false, unique = false)
    private boolean isDeleted;
}
