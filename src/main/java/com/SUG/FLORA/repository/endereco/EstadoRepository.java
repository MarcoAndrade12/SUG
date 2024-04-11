package com.SUG.FLORA.repository.endereco;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SUG.FLORA.model.endereco.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

    List<Estado> findAllByDeletedFalse();

	boolean existsByNomeIgnoreCase(String nome);

	Estado findByNome(String nome);

}
