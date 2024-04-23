package com.SUG.FLORA.configuration;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.enums.EnumStatusUsuario;
import com.SUG.FLORA.model.Profile;
import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.repository.ProfileRepository;
import com.SUG.FLORA.repository.UsuarioRepository;
import com.SUG.FLORA.services.UsuarioService;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {
	@Autowired
    UsuarioRepository usuarioRepository;
	
	AuthenticationManager authenticationManager;

    @Autowired
    ProfileRepository profileRepository;

    @Autowired
    UsuarioService usuarioService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf( t -> t.disable());

        http
            .authorizeHttpRequests(requests -> requests
                .requestMatchers("/login").permitAll()
                .requestMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**", "/printer/**" , "/teste.html", "/index.html", "/index_agent.html",  "/topic/", "/ws", "/report/**",
                "/chat/**").permitAll()
                .requestMatchers("/index").authenticated()
                .anyRequest().authenticated()
            )
            .formLogin((formLogin) ->
                formLogin
                    .loginPage("/login").permitAll()
                    .loginProcessingUrl("/login").permitAll()
                    .defaultSuccessUrl("/index", true)
            );  

            http.userDetailsService((UserDetailsService) usuarioService);
        
        confnewAdminInMemory();

        return http.build();

    }

    public void confnewAdminInMemory() throws Exception{
        if (usuarioRepository.findAll().size() == 0) {

            Profile profile = profileRepository.findByName("ROLE_ADMIN");

            if ( profile == null) {
                profile = new Profile();
                profile.setName("ADMIN");
            } 
                
            Usuario u = new Usuario();
            u.setEmail("admin@admin.com");
            u.setSenha(passwordEncoder().encode("admin"));
            u.setCpf("132");
            u.setRg("20251256");
            u.setNome("Teste");
            u.setSobrenome("Testes");
            u.setSexo(EnumSexo.MASCULINO);
            u.setStatus(EnumStatusUsuario.ATIVO);
            u.setConsentimento(true);
            u.getProfiles().add(profile);;
            
            try {
                usuarioRepository.save(u);
            } catch (Exception e) {
                System.out.println("Erro ao salvar usuário");
            }



        }
        

    }

    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
