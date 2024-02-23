package dev.prulloac.crudrestapidemo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest
@Testcontainers
@TestPropertySource(properties = {
	"spring.datasource.url=jdbc:tc:postgresql:16-alpine:///crudrestapidemo",
	"spring.datasource.driver-class-name=org.testcontainers.jdbc.ContainerDatabaseDriver",
	"spring.jpa.hibernate.ddl-auto=create-drop"
})
class CrudRestApiDemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
