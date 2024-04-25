package com.SUG.FLORA.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, UUID> {

    public List<Projeto> findByUsuarioDonoEmail(String email);

    public boolean existsByNomeAndUsuarioDonoEmail(String nome, String email);

}
