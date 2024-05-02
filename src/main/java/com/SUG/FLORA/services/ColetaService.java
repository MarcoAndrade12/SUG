package com.SUG.FLORA.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SUG.FLORA.model.Coleta;
import com.SUG.FLORA.model.Especie;
import com.SUG.FLORA.model.Familia;
import com.SUG.FLORA.model.Genero;
import com.SUG.FLORA.repository.ColetaRepository;
import com.SUG.FLORA.repository.FamiliaRepository;

import jakarta.transaction.Transactional;

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

    public Especie findOrCreateEspecieByNome(String nome_cientifico_especie) {

        Especie especie = especieService.findByName(nome_cientifico_especie);

        if (especie != null) {
            return especie;
        } else {
            especie = new Especie();
            especie.setNome_cientifico(nome_cientifico_especie);
            especieService.save(especie);
            return especie;
        }

    }

    public Genero findOrCreateGeneroByNome(String nome_cientifico_genero) {
        Genero genero = generoService.findByName(nome_cientifico_genero);

        if (genero != null) {
            return genero;
        } else {
            genero = new Genero();
            genero.setNome_cientifico(nome_cientifico_genero);
            generoService.save(genero);
            return genero;
        }
    }

    @Transactional
    public Genero setEspecieOfGenero(Especie especie, Genero genero) {

        genero.getEspecies().add(especie);

        return genero;
    }

    public Familia findOrCreateFamiliaByNome(String nome_cientifico_familia) {
        Familia familia = familiaService.findByName(nome_cientifico_familia);

        if (familia != null) {
            return familia;
        } else {
            familia = new Familia();
            familia.setNome_cientifico(nome_cientifico_familia);
            familiaService.save(familia);
            return familia;
        }
    }

    @Transactional
	public Familia setGeneroOfFamilia(Genero genero, Familia familia) {
		familia.getGeneros().add(genero);
        return familia;
	}

    public void saveColeta(Coleta coleta) {
        coletaRepository.save(coleta);
    }

    public Coleta findById(UUID id) {
        Coleta coleta = coletaRepository.findById(id).get();
        return coleta;
    }

    public void delete(Coleta coleta) {
        coletaRepository.delete(coleta);
    }   

}
