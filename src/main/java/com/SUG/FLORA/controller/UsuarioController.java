package com.SUG.FLORA.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.exceptions.AtributoDuplicadoException;
import com.SUG.FLORA.exceptions.AtributoInvalidoException;
import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.model.DTOs.ProfileDTO;
import com.SUG.FLORA.model.DTOs.UsuarioDTO;
import com.SUG.FLORA.services.EnderecoService;
import com.SUG.FLORA.services.UsuarioService;

@Controller
@RequestMapping(value = "/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    EnderecoService enderecoService;

    @GetMapping("")
    public String getPage(Model model) {

        List<UsuarioDTO> usuariosDTOs = usuarioService.findAllUsuariosDTOsByDeletedFalse();

        model.addAttribute("usuarios", usuariosDTOs);

        return "admin/usuarios_admin";
    }
    
    @GetMapping("editar-usuario/{id}")
    public String getPage(Model model, @PathVariable String id) {

        Usuario u = usuarioService.findById(UUID.fromString(id));
        System.out.println("Id -> " + id);
        if(u!=null) {
        	System.out.println("Editando Usuario -> " + u.getNome());
        }

    

        return "admin/usuarios_admin";
    }

    @GetMapping("cadastrar")
    public String getPageNovoUsuario(Model model) {

        EnumSexo[] sexoDTOs = EnumSexo.values();
        model.addAttribute("sexos", sexoDTOs);

        return "admin/novo_usuario_admin";
    }

    @GetMapping("editar")
    public String getPageEditarUsuario() {
        return "admin/editar_usuario_admin";
    }

    @PostMapping("")
    public ResponseEntity<String> novoUsuario(@RequestBody MultiValueMap<String, String> body) {

        ProfileDTO profile = new ProfileDTO(body);
        profile.setName("ROLE_USER");
        
        UsuarioDTO usuarioDTO = new UsuarioDTO(body);
        usuarioDTO.getProfiles().add(profile);
        usuarioDTO.setStatus("ATIVO");
                
        try {
            Usuario usuario = usuarioDTO.getModel();
            usuario.setSenha("mudar@123");
            Usuario usuarioSaved = usuarioService.salvarUsuario(usuario);
            
            return ResponseEntity.ok().body(usuarioSaved.getCpf());

        } catch (AtributoDuplicadoException error) {
        	error.printStackTrace();
            System.out.println(error.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error.getLocalizedMessage());
        
        } catch (AtributoInvalidoException error) {
        	error.printStackTrace();
            System.out.println(error.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error.getLocalizedMessage());
        
        } catch (Exception error) {
        	error.printStackTrace();
            System.out.println(error.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Não foi possível cadastrar o usuário");
        }

    }

}
