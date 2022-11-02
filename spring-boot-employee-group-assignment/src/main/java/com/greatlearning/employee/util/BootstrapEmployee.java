package com.greatlearning.employee.util;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.github.javafaker.Faker;
import com.greatlearning.employee.model.Employee;
import com.greatlearning.employee.repository.EmployeeRepository;

@Configuration
public class BootstrapEmployee {

	private final EmployeeRepository employeeRepository;
	private final Faker fakeEmp = new Faker();


	public BootstrapEmployee(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
		
	}
	
	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationReady(ApplicationReadyEvent event) {
		for(int i=0; i<10; i++) {
			String fName = fakeEmp.name().firstName();
			String lName = fakeEmp.name().lastName();
			
			Employee employee = Employee
					.builder()
					.firstName(fName)
					.lastName(lName)
					.email(fName+"."+lName+"@"+fakeEmp.internet()
					.domainName())
					.build();
			
			this.employeeRepository.save(employee);
			
		}
		
	}
}
