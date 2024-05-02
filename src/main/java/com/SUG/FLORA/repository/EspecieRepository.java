package com.SUG.FLORA.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer> {

    @Query("SELECT ec FROM Especie e JOIN e.nome_comum ec")
    List<String> findAllNomeComum();

    @Query(value = "SELECT nome_comum FROM especie e WHERE e.nome_cientifico = :nomeCientifico", nativeQuery = true)
    List<String> findAllNomeComumByNomeCientifico(String nomeCientifico);
    
    @Query(value = "SELECT * FROM especie e WHERE e.nome_cientifico = :nomeCientifico", nativeQuery = true)
    Especie findBynome_cientifico(String nomeCientifico);
}
