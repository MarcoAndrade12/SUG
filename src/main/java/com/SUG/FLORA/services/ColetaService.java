package com.SUG.FLORA.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.model.Genero;
import com.SUG.FLORA.repository.ColetaRepository;
import com.SUG.FLORA.repository.FamiliaRepository;

@Service
public class ColetaService {

    @Autowired
    ColetaRepository coletaRepository;

    @Autowired
    FamiliaService familiaService;

    @Autowired
    GeneroService generoService;

    @Autowired
    EspecieService especieService;

    @Autowired
    EnderecoService enderecoService;

    public List<String> findAllNomesComuns() {

        List<String> nomes_comuns = especieService.findAllNomesComuns();

        return nomes_comuns;
    }

    public List<String> findAllNomesComunsByEspecieNome(String nome_especie) {
        List<String> nomes_comuns = especieService.findAllNomesComunsByEspecieNome(nome_especie);
        return nomes_comuns;
    }

}
