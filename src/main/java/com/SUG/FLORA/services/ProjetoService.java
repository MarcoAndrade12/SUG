package com.SUG.FLORA.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.model.Projeto;
import com.SUG.FLORA.model.DTOs.ProjetoDTO;
import com.SUG.FLORA.repository.ProjetoRepository;

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

}
