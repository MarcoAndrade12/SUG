package com.SUG.FLORA;

import com.SUG.FLORA.DatabaseConnection; // Corrigindo o import para a classe DatabaseConnection
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FloraApplication {

    public static void main(String[] args) {
        // Inicializa a conexão com o banco de dados antes de iniciar a aplicação Spring Boot
        DatabaseConnection.main(args);

        // Inicia a aplicação Spring Boot
        SpringApplication.run(FloraApplication.class, args);
    }
}
