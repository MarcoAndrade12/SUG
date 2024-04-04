package com.SUG.FLORA.repository.endereco;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.endereco.Pais;

@Repository
public interface PaisRepository extends JpaRepository<Pais, Integer> {

    List<Pais> findAllByDeletedFalse();

}
