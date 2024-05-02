package com.SUG.FLORA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.model.Especie;
import com.SUG.FLORA.repository.EspecieRepository;

@Service
public class EspecieService {
    
    @Autowired
    EspecieRepository especieRepository;

    public List<String> findAllNomesComuns() {
        
        return especieRepository.findAllNomeComum();
    }

    public List<String> findAllNomesComunsByEspecieNome(String nome_especie) {
        

        return especieRepository.findAllNomeComumByNomeCientifico(nome_especie);
    }

    public Especie findByName(String nome_cientifico_especie) {
        Especie especie = especieRepository.findBynome_cientifico(nome_cientifico_especie);

        return especie;
    }

    public void save(Especie especie) {
        especieRepository.save(especie);
    }

}
