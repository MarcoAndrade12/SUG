package com.SUG.FLORA.controllerRest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.services.EnderecoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/endereco")
public class EnderecoAPI {

    @Autowired
    EnderecoService enderecoService;

    private JsonNode getJsonByURL(String url) {
        RestTemplate restTemplate = new RestTemplate();
        String jsonResponse = restTemplate.getForObject(url, String.class);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode jsonNode = objectMapper.readTree(jsonResponse);
            return jsonNode;
            // Use jsonNode para trabalhar com os dados JSON

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;

    }

}
