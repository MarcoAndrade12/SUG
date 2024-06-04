package com.SUG.FLORA.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.SUG.FLORA.model.Campo;
import com.SUG.FLORA.model.Coleta;
import com.SUG.FLORA.model.Projeto;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, UUID> {

    public List<Projeto> findByUsuarioDonoEmail(String email);

    public boolean existsByNomeAndUsuarioDonoEmail(String nome, String email);

    @Query(value = "SELECT * FROM coleta c WHERE c.projeto_id = :id", nativeQuery = true)
    public List<Coleta> getColetasByProjetoId(UUID id);

    @Query(value = "SELECT c FROM campo c JOIN projeto_campo pc ON pc.campo_id = c.id WHERE c.id = :id")
    public List<Campo> findAllCamposByProjetoId(UUID id);

}
