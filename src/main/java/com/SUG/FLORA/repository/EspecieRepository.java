package com.SUG.FLORA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SUG.FLORA.model.Especie;

public interface EspecieRepository extends JpaRepository<Especie, Integer>{
    
}
