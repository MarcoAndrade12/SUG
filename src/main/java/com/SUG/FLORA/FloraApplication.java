package com.SUG.FLORA;
import com.SUG.FLORA.database.DatabaseConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FloraApplication {

	public static void main(String[] args) {
		SpringApplication.run(FloraApplication.class, args);
		DatabaseConnection.main(args);

	}

}
