package com.SUG.FLORA.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.Familia;

@Repository
public interface FamiliaRepository extends JpaRepository<Familia, Integer> {

    @Query(value = "SELECT * FROM familia f WHERE f.nome_cientifico = :nomeCientifico", nativeQuery = true)
    Familia findBynome_cientifico(String nomeCientifico);

}
