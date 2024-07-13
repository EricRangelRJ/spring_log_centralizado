package br.com.arq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class LogcentralizadoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogcentralizadoApplication.class, args);
	}

}
