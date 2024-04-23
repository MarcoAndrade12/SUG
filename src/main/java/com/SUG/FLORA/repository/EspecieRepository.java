package com.SUG.FLORA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.Especie;

@Repository
public interface EspecieRepository extends JpaRepository<Especie, Integer> {

}
