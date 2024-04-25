package com.SUG.FLORA.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.enums.EnumStatusUsuario;
import com.SUG.FLORA.model.Endereco;
import com.SUG.FLORA.model.Profile;
import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.services.ProfileService;
import com.SUG.FLORA.services.UsuarioService;

@Controller
@RequestMapping("cadastro")
public class UsuarioCadastroController {

    @Autowired
    UsuarioService usuarioService;

    @Autowired
    ProfileService profileService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @GetMapping("")
    public String getPage() {
        return "temp/cadastro";
    }

    @PostMapping("")
    public String novoUsuario(@RequestBody MultiValueMap<String, String> body) {

        try {
            Usuario user = new Usuario();

            user.setNome(body.getFirst("primeiro_nome"));
            user.setSobrenome(body.getFirst("sobrenome"));
            user.setRg(body.getFirst("rg"));
            user.setCpf(body.getFirst("cpf"));
            user.setSexo(EnumSexo.stringToSexo(body.getFirst("sexo")));
            user.setEmail(body.getFirst("email"));
            user.setStatus(EnumStatusUsuario.ATIVO);
            user.setSenha(passwordEncoder.encode(body.getFirst("senha1")));

            Profile profile = profileService.findByName("ROLE_USER");

            if (profile == null) {
                profile = new Profile();
                profile.setName("ROLE_USER");
            }

            List<Profile> profiles = new ArrayList<Profile>();
            profiles.add(profile);
            user.setProfiles(profiles);

            Endereco endereco = new Endereco();
            endereco.setCidade(body.getFirst("cidade"));
            endereco.setEstado(body.getFirst("estado"));
            endereco.setPais(body.getFirst("pais"));

            user.setEndereco(endereco);

            Usuario usuarioSaved = usuarioService.salvarUsuario(user);

            return "login";

        } catch (Exception error) {
            error.printStackTrace();
            System.out.println(error.getLocalizedMessage());
            return error.getMessage();
        }

    }

}
