package com.greatlearning.employee;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Employees Rest API",contact = @Contact(email = "contact@glearning.com",name = "Me")))
//@EnableWebSecurity
public class SpringBootEmployeeAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEmployeeAssignmentApplication.class, args);
	}

}
