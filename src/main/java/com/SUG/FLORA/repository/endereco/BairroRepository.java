package com.SUG.FLORA.repository.endereco;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SUG.FLORA.model.endereco.Bairro;

public interface BairroRepository extends JpaRepository<Bairro, UUID> {

    List<Bairro> findAllByDeletedFalse();

}
