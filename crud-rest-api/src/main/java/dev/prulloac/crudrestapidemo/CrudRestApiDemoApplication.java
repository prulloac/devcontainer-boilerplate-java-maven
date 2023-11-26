package dev.prulloac.crudrestapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class CrudRestApiDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudRestApiDemoApplication.class, args);
	}

}
