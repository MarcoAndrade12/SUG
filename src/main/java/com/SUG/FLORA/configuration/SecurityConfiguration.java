package com.SUG.FLORA.configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.SUG.FLORA.enums.EnumSexo;
import com.SUG.FLORA.enums.EnumStatusUsuario;
import com.SUG.FLORA.model.Profile;
import com.SUG.FLORA.model.Usuario;
import com.SUG.FLORA.repository.UsuarioRepository;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
public class SecurityConfiguration {
	@Autowired
    UsuarioRepository usuarioRepository;
	
	AuthenticationManager authenticationManager;
	 
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        AuthenticationManagerBuilder authenticationManagerBuilder = http.getSharedObject(AuthenticationManagerBuilder.class);
        authenticationManagerBuilder.userDetailsService(jwtUserDetailsService).passwordEncoder(passwordEncoder());
        
        authenticationManager = authenticationManagerBuilder.build();

        http
        .csrf()
        .disable()
		.authorizeHttpRequests()
		.antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/img/**", "/icon/**", "/printer/**" , "/teste.html", "/index.html", "/index_agent.html",  "/topic/", "/ws", "/report/**",
					 "/chat/**").permitAll()
		.anyRequest().authenticated()
        .and()       
		.formLogin(form -> form.loginPage("/login").permitAll().defaultSuccessUrl("/index", true))
		.logout(logout -> logout.logoutUrl("/logout"))		
		.authenticationManager(authenticationManager)
		.sessionManagement().maximumSessions(1)
		.maxSessionsPreventsLogin(true)
		.expiredUrl("/login");
        
        confnewAdminInMemory();

        return http.build();

        
    }

    public void confnewAdminInMemory(){
        List<Usuario> usuarios = usuarioRepository.findAll();

        if (usuarios.isEmpty()) {
            List<Profile> profiles = new ArrayList<>();
            
            Profile prof = new Profile();
            prof.setName("ADMIN");
            prof.setCreationDate(LocalDateTime.now());
            
            profiles.add(prof);


            Usuario u = new Usuario();
            u.setEmail("teste@teste.com");
            u.setSenha(passwordEncoder().encode("123"));
            u.setCpf("132");
            u.setRg("20251256");
            u.setNome("Teste");
            u.setSobrenome("Testes");
            u.setSexo(EnumSexo.MASCULINO);
            u.setStatus(EnumStatusUsuario.ATIVO);
            u.setConsentimento(true);
            u.setProfiles(profiles);

            System.out.println(u);
            usuarioRepository.save(u);

        }
    }

    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
