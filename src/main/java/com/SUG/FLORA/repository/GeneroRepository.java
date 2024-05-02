package com.SUG.FLORA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.Genero;

@Repository
public interface GeneroRepository extends JpaRepository<Genero, Integer> {

    @Query(value = "SELECT * FROM genero g WHERE g.nome_cientifico = :nomeCientifico", nativeQuery = true)
    Genero findBynome_cientifico(String nomeCientifico);

}
