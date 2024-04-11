package com.SUG.FLORA.repository.endereco;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SUG.FLORA.model.endereco.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

    List<Cidade> findAllByDeletedFalse();

	Cidade findByNome(String nome);

	boolean existsByNomeIgnoreCase(String nome);
}
