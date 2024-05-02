package com.SUG.FLORA.controllerRest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.spi.ObjectThreadContextMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.SUG.FLORA.model.Campo;
import com.SUG.FLORA.model.Coleta;
import com.SUG.FLORA.model.Especie;
import com.SUG.FLORA.model.Familia;
import com.SUG.FLORA.model.Genero;
import com.SUG.FLORA.model.Projeto;
import com.SUG.FLORA.model.DTOs.ColetaDTO;
import com.SUG.FLORA.services.CampoService;
import com.SUG.FLORA.services.ColetaService;
import com.SUG.FLORA.services.ProjetoService;

import io.micrometer.core.ipc.http.HttpSender.Response;
import jakarta.transaction.Transactional;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequestMapping(value = "/coletas")
public class ColetasRestController {

    @Autowired
    ColetaService coletaService;

    @Autowired
    CampoService campoService;

    @Autowired
    ProjetoService projetoService;
 

    @GetMapping("nomes_comuns")
    public ResponseEntity<Object> getNomesComuns(){

        List<String> nomes_comuns = coletaService.findAllNomesComuns();
        
        return ResponseEntity.ok().body(nomes_comuns);
        
    }

    @GetMapping("nomes_comuns/especie/{especie}")
    public ResponseEntity<Object> getNomesComunsByNomeEspecie(@PathVariable String especie) {
        List<String> nomes_comuns = coletaService.findAllNomesComunsByEspecieNome(especie);        
        return ResponseEntity.ok().body(nomes_comuns);
    }

    @PostMapping("nova_coleta")
    public String novaColeta(@RequestBody MultiValueMap<String, String> post) {

        System.out.println(post);

        Especie especie = coletaService.findOrCreateEspecieByNome(post.getFirst("especie"));

        Genero genero = coletaService.findOrCreateGeneroByNome(post.getFirst("genero"));
        genero = coletaService.setEspecieOfGenero(especie, genero);

        Familia familia = coletaService.findOrCreateFamiliaByNome(post.getFirst("familia"));
        familia = coletaService.setGeneroOfFamilia(genero, familia);

        Coleta coleta = new Coleta();
        coleta.setFamilia(familia);
        coleta.setGenero(genero);
        coleta.setEspecie(especie);

        System.out.println(post.getFirst("data_coleta"));

        coleta.setData_coleta(LocalDate.parse(post.getFirst("data_coleta")));
        coleta.setCodigoId(Integer.parseInt(post.getFirst("codigo_id")));

        coletaService.saveColeta(coleta);
        
        Campo campo = campoService.findOrCreateByNome(post.getFirst("campo"));
        campo = campoService.setColetaOfCampo(coleta, campo);

        projetoService.addCampoIfNotExist(campo, UUID.fromString(post.getFirst("projeto_id")));
        projetoService.addColeta(coleta, UUID.fromString(post.getFirst("projeto_id")));


        return "redirect:/projetos/meuprojeto/" + post.getFirst("projeto_id");
    }

    @PostMapping("excluir")
    public String deleteColetaById(@RequestBody MultiValueMap<String, String> post) {

        Coleta coleta = coletaService.findById(UUID.fromString(post.getFirst("coleta_id")));

        coletaService.delete(coleta);

        return "redirect:/projetos/meuprojeto/" + post.getFirst("projeto_id");

    }

    @PostMapping("update")
    @Transactional
    public String UpdateColeta(@RequestBody MultiValueMap<String, String> post) {
        Coleta coleta = coletaService.findById(UUID.fromString(post.getFirst("coleta_id")));

        Especie especie = coletaService.findOrCreateEspecieByNome(post.getFirst("especie"));
        Genero genero = coletaService.findOrCreateGeneroByNome(post.getFirst("genero"));
        genero = coletaService.setEspecieOfGenero(especie, genero);

        Familia familia = coletaService.findOrCreateFamiliaByNome(post.getFirst("familia"));
        familia = coletaService.setGeneroOfFamilia(genero, familia);

        Campo campo = campoService.findOrCreateByNome(post.getFirst("campo"));
        
        coleta.setCodigoId(Integer.parseInt(post.getFirst("codigo")));
        coleta.setFamilia(familia);
        coleta.setGenero(genero);
        coleta.setEspecie(especie);
        coleta.setCampo(campo);
        coleta.setData_coleta(LocalDate.parse(post.getFirst("data_coleta")));

        return "redirect:/projetos/meuprojeto/" + post.getFirst("projeto_id");
    }

}
