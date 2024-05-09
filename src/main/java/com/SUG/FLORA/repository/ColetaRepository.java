package com.SUG.FLORA.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.Coleta;

@Repository
public interface ColetaRepository extends JpaRepository<Coleta, UUID> {

    @Query(value = "SELECT MAX(codigo_id) FROM coleta WHERE projeto_id = :projeto_Uuid ", nativeQuery=true)
    Integer getLastCodigoColetaByProjetoId(UUID projeto_Uuid);

}
