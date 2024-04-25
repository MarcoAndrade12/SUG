package com.SUG.FLORA.controllerRest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.SUG.FLORA.model.DTOs.ColetaDTO;
import com.SUG.FLORA.services.ColetaService;

import io.micrometer.core.ipc.http.HttpSender.Response;

@RestController
@RequestMapping("coletas/")
public class ColetasRestController {

    @Autowired
    ColetaService coletaService;


    @GetMapping("nomes_comuns")
    public ResponseEntity<Object> getNomesComunsByNomeEspecie(
        @RequestParam(required = false) String especie,
        @RequestParam(required = false) String genero,
        @RequestParam(required = false) String familia) {

        if (especie != null && especie.length() > 0) {
            System.out.println("Consultaram /coletas/nomes_comuns?" + especie);
            List<String> nomes_comuns = coletaService.findAllNomesComunsByEspecieNome(especie);
            // TODO: Parei aqui
            return ResponseEntity.ok().body(nomes_comuns);
        }else{
            
            List<String> nomes_comuns = coletaService.findAllNomesComuns();

            System.out.println("Consultaram /coletas/nomes_comuns");
    
            return ResponseEntity.ok().body(nomes_comuns);

        }
    }

}
