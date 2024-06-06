package com.SUG.FLORA.controllerRest;

import java.util.List;
import java.util.UUID;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SUG.FLORA.model.Campo;
import com.SUG.FLORA.model.Coleta;
import com.SUG.FLORA.model.DTOs.CampoDTO;
import com.SUG.FLORA.model.DTOs.ColetaDTO;
import com.SUG.FLORA.services.CampoService;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("api/campos")
public class CamposRestController {
    
    @Autowired
    CampoService campoService;

    @GetMapping("")
    public List<CampoDTO> findAll(){
        List<Campo> campos = campoService.findAll();
        return campos.stream().map(Campo::getDTO).toList();
    }

    @GetMapping("projeto/{id}")
    public ResponseEntity<List<CampoDTO>> findAllByProjetoId(@PathVariable String id) {
        List<CampoDTO> camposDTOs = campoService.findAllDTOsByProjetoId(UUID.fromString(id));
        return ResponseEntity.ok().body(camposDTOs);
    }
    
    @GetMapping("{id}/coletas")
    public ResponseEntity<List<ColetaDTO>> findAllColetasById(@PathVariable String id) {
        List<ColetaDTO> coletasDTOs = campoService.findAllColetasDTOsById(UUID.fromString(id));
        return ResponseEntity.ok().body(coletasDTOs);
    }

    @PostMapping("novo")
    @Operation(description = "Cria um novo campo")
    public ResponseEntity<CampoDTO> novoCampo(@RequestBody CampoDTO campoDTO) {
        

        return ResponseEntity.ok().body(campoDTO);
    }

}
