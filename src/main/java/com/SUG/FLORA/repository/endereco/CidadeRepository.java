package com.SUG.FLORA.repository.endereco;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SUG.FLORA.model.endereco.Cidade;
import com.SUG.FLORA.model.endereco.Estado;

public interface CidadeRepository extends JpaRepository<Cidade, UUID> {

    List<Cidade> findAllByDeletedFalse();
}
