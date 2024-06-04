package com.SUG.FLORA.controllerRest;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SUG.FLORA.model.Campo;
import com.SUG.FLORA.model.DTOs.CampoDTO;
import com.SUG.FLORA.services.CampoService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("campos")
public class CamposRestController {
    
    @Autowired
    CampoService campoService;

    @GetMapping("")
    public List<CampoDTO> findAll(){
        List<Campo> campos = campoService.findAll();
        return campos.stream().map(Campo::getDTO).toList();
    }

    @GetMapping("projeto/{id}")
    public ResponseEntity<Object> findAllByProjetoId(@PathVariable String id) {
        List<Campo> campos = campoService.findAllByProjetoId(UUID.fromString(id));
        List<CampoDTO> camposDTOs = campos.stream().map(Campo::getDTO).toList();
        
        return ResponseEntity.ok().body(camposDTOs);
    }
    
}
