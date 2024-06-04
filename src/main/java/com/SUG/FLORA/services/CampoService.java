package com.SUG.FLORA.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.model.Campo;
import com.SUG.FLORA.model.Coleta;
import com.SUG.FLORA.model.DTOs.CampoDTO;
import com.SUG.FLORA.repository.CampoRepository;

import jakarta.transaction.Transactional;

@Service
public class CampoService {

    @Autowired
    CampoRepository campoRepository;

    @Autowired
    ProjetoService projetoService;

    public Campo findOrCreateByNome(String nome_campo) {
        Campo campo = campoRepository.findByNome(nome_campo);
        if (campo != null) {
            return campo;
        } else {
            campo = new Campo();
            campo.setNome(nome_campo);
            campoRepository.save(campo);
            return campo;
        }
    }

    @Transactional
    public Campo setColetaOfCampo(Coleta coleta, Campo campo) {
        campo.getColetas().add(coleta);
        
        return campo;
    }

    public List<Campo> findAll() {
        return campoRepository.findAll();
    }

    public List<Campo> findAllByProjetoId(UUID id) {
        return projetoService.findAllCamposByIdProjeto(id);
    }

}
