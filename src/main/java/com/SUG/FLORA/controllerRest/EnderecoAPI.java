package com.SUG.FLORA.controllerRest;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.SUG.FLORA.interfaces.DTOConvertible;
import com.SUG.FLORA.model.DTOs.PaisDTO;
import com.SUG.FLORA.model.endereco.Cidade;
import com.SUG.FLORA.model.endereco.Estado;
import com.SUG.FLORA.model.endereco.Pais;
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


    @GetMapping("pais")
    public List<Pais> getPais(){
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");

        Pais brasil = new Pais();
        brasil.setId(1);
        brasil.setNome("Brasil");
        brasil.setSigla("BR");
        brasil.setCreationDate(LocalDateTime.now());
        
        JsonNode estados = getJsonByURL("https://servicodados.ibge.gov.br/api/v1/localidades/estados");
        
        for (JsonNode estadoNode : estados) {
            Estado estado = new Estado();
            
            int estado_id = estadoNode.get("id").asInt();
            String estado_sigla = estadoNode.get("sigla").asText(); 
            String estado_nome = estadoNode.get("nome").asText();
            
            estado.setId(estado_id);
            estado.setSigla(estado_sigla);
            estado.setNome(estado_nome);

            JsonNode cidades = getJsonByURL("https://servicodados.ibge.gov.br/api/v1/localidades/estados/" + estado_sigla + "/municipios");

            for (JsonNode cidadNode : cidades) {
                Cidade cidade = new Cidade();

                int cidade_id = cidadNode.get("id").asInt();
                String cidade_nome = cidadNode.get("nome").asText();

                cidade.setId(cidade_id);
                cidade.setNome(cidade_nome);

                cidade = enderecoService.salvarCidade(cidade);
                estado.getCidades().add(cidade);
            }

            brasil.getEstados().add(estado);
             
        }


        List<Pais> pais = new ArrayList<Pais>();
        System.out.println(brasil.getDTO());

        return pais;
    }

}
