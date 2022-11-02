package com.greatlearning.employee.controller;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee.model.Employee;
import com.greatlearning.employee.service.EmployeeService;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {
	
	private final EmployeeService employeeService;
	
	public EmployeeController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
//	Read All	
	@GetMapping
	public Set<Employee> listAll(){
		return this.employeeService.listAll();
	}
	
//	Read by Id
	@GetMapping("/{id}")
	public Employee getEmployeeById(@PathVariable("id") long employeeId) {
		return this.employeeService.getEmployeeById(employeeId);
	}
	
//	Create
	@PostMapping("addEmployee")
	@ResponseStatus(HttpStatus.CREATED)
	public Employee addEmployee(@RequestBody Employee newEmployee) {
		System.out.println(newEmployee);
		return this.employeeService.addEmployee(newEmployee);
	}

//	Update Employee
	@PutMapping("/{id}")
	public Employee updateEmployeeById(@PathVariable("id") long employeeId, @RequestBody Employee employee) {
		return this.employeeService.updateEmployeeById(employeeId, employee);
	}
	
//	Delete Employee
	@DeleteMapping("delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteEmployeeById(@PathVariable("id") long employeeId) {
		this.employeeService.deleteEmployeeById(employeeId);
	}
	
//	Search by first name
//	@GetMapping("FirstName/{Name}")
	@GetMapping("search/{Name}")
	public List<Employee> getEmployeeByFirstName(@PathVariable("Name") String firstName){
		System.out.println("name to search "+firstName);
		return this.employeeService.getEmployeeByFirstName(firstName);
		
	}
	
//	Sort dynamically by first name
	@GetMapping("sort/{order}")
	public List<Employee> getEmployeeCustomSortedByName(@RequestParam(name = "order", defaultValue = "ASC", required = false) Direction sortOrder){
		return this.employeeService.getEmployeeDynamicSortedByFirstName(sortOrder);
	}
}
