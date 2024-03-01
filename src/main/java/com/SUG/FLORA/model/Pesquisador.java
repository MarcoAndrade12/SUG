package com.SUG.FLORA.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.enums.EnumStatusUsuario;
import com.SUG.FLORA.model.endereco.Endereco;

import jakarta.annotation.Generated;
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
public class Pesquisador {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    
    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = false)
    private String password;

    @Column(nullable = false, unique = false)
    private boolean consentimento;

    @Column(nullable = false, unique = false)
    private LocalDate data_cadastro;

    @Column(nullable = false, unique = false)
    private LocalDateTime deleted;

    @Column(nullable = false, unique = false)
    private String nome;

    @Column(nullable = false, unique = false)
    private String sobrenome;

    @Column(nullable = false, unique = true)
    private String rg;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Enumerated(EnumType.STRING)
    private EnumSexo sexo;

    @Enumerated(EnumType.STRING)
    private EnumStatusUsuario status;

    @ManyToOne
    @JoinColumn(name = "endereco_id", nullable = false, unique = false)
    private Endereco endereco;

}
