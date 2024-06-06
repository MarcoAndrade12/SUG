package com.SUG.FLORA.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.Campo;
import com.SUG.FLORA.model.DTOs.CampoDTO;
import com.SUG.FLORA.model.DTOs.ColetaDTO;

@Repository
public interface CampoRepository extends JpaRepository<Campo, UUID> {
    public Campo findByNome(String nome);

    public List<ColetaDTO> findAllColetasById(UUID id);

}
