package com.SUG.FLORA.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.model.Campo;
import com.SUG.FLORA.model.Coleta;
import com.SUG.FLORA.model.Projeto;
import com.SUG.FLORA.model.DTOs.ProjetoDTO;
import com.SUG.FLORA.repository.ProjetoRepository;

import jakarta.transaction.Transactional;

@Service
public class ProjetoService {

    @Autowired
    ProjetoRepository projetoRepository;

    public boolean existsByNomeAndUsuarioDonoEmail(String nome, String email) {
        return projetoRepository.existsByNomeAndUsuarioDonoEmail(nome, email);
    }

    public List<Projeto> findAllByUsuarioDonoEmail(String email) {
        return projetoRepository.findByUsuarioDonoEmail(email);
    }

    public Projeto save(Projeto projeto) {
        return projetoRepository.save(projeto);
    }

    public List<ProjetoDTO> findAllDTOByUsuarioEmail(String email) {

        List<Projeto> projetos = findAllByUsuarioDonoEmail(email);

        return projetos.stream().map(projetoDTO -> projetoDTO.getDTO()).toList();

    }

    public Projeto findById(UUID id) {
        return projetoRepository.findById(id).get();
    }

    @Transactional
    public void addCampoIfNotExist(Campo campo, UUID projeto_UUID) {
        Projeto projeto = projetoRepository.findById(projeto_UUID).get();
        
        boolean existe = projeto.getCampos().stream().anyMatch(campoP -> campoP.getId() == campo.getId());
        
        if (!existe) {
            projeto.getCampos().add(campo);
        }
        
    }
    
    @Transactional
    public void addColeta(Coleta coleta, UUID projeto_UUID) {
        Projeto projeto = projetoRepository.findById(projeto_UUID).get();
        projeto.getColetas().add(coleta);
    }

    public List<Coleta> findAllColetasByProjetoUuid(UUID projeto_Uuid) {
        return projetoRepository.getColetasByProjetoId(projeto_Uuid);
    }

}
