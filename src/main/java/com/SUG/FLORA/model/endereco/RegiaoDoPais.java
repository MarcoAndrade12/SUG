package com.SUG.FLORA.model.endereco;

import java.util.List;
import java.util.Set;

import com.SUG.FLORA.enums.EnumRegiao;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
public class RegiaoDoPais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    @Enumerated(EnumType.STRING)
    private EnumRegiao nome;

    @OneToMany
    @JoinColumn(name = "regiao_id")
    private List<Estado> estados;

    @Column(nullable = false, unique = false)
    private boolean isDeleted;

}
