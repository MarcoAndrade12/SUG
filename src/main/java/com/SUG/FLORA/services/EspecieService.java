package com.SUG.FLORA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
