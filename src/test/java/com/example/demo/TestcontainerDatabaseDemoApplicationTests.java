package com.example.demo;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
@Testcontainers
class TestcontainerDatabaseDemoApplicationTests {

	@LocalServerPort
	int port;

	@BeforeEach
	void setUp() {
		RestAssured.port = port;
	}

	@Container
	@ServiceConnection
	static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:latest");

//	@DynamicPropertySource
//	static void configureProperties(DynamicPropertyRegistry registry){
//		registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
//		registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
//		registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
//	}

	@Test
	void shouldGetAllCustomers() {
		RestAssured.given()
				.when()
				.get("/api/customers")
				.then()
				.statusCode(200)
				.body("size()", is(3));
	}
}
