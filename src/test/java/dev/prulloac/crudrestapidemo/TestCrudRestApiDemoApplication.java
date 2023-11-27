package dev.prulloac.crudrestapidemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.TestConfiguration;
import org.testcontainers.junit.jupiter.Testcontainers;

@TestConfiguration(proxyBeanMethods = false)
@Testcontainers
public class TestCrudRestApiDemoApplication {
	//This class is meant for either integration tests or running the application locally with a test database

	public static void main(String[] args) {
		SpringApplication.from(CrudRestApiDemoApplication::main).with(TestCrudRestApiDemoApplication.class).run(args);
	}

}
