package com.greatlearning.employee.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.model.Employee;
import com.greatlearning.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
//	Create
	public Employee addEmployee(Employee employee) {
		System.out.println("Saving the Employee to the set...." +employee);
		Employee savedEmployee = this.employeeRepository.save(employee);
		System.out.println("Added Data: "+savedEmployee);
		return savedEmployee;
	}
	
//	Read All
	public Set<Employee> listAll(){
		return new HashSet<>(this.employeeRepository.findAll());
	}
	
//	Read by Id
	public Employee getEmployeeById(long employeeId) {
		return this.employeeRepository.findById(employeeId).orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id"));
	}
	
//	Delete by Id
	public void deleteEmployeeById(long employeeId) {
		this.employeeRepository.deleteById(employeeId);
	}
	
//	Updated By Id
	public Employee updateEmployeeById(long employeeId, Employee updatedEmployee) {
		Employee employeeFromDb = this.getEmployeeById(employeeId);
		System.out.println(employeeFromDb);
		employeeFromDb.setFirstName(updatedEmployee.getFirstName());
		employeeFromDb.setLastName(updatedEmployee.getLastName());
		employeeFromDb.setEmail(updatedEmployee.getEmail());
		System.out.println(employeeFromDb);
		this.employeeRepository.saveAndFlush(employeeFromDb);
		return employeeFromDb;
	}
	
//	Fetch Employee By First Name
	public List<Employee> getEmployeeByFirstName(String firstName){
		List<Employee> resultEmp = (List<Employee>) this.employeeRepository.fetchEmployeeByFirstName(firstName);
		return resultEmp;
	}
	
	//sorting
	public List<Employee> getEmployeeDynamicSortedByFirstName(Direction direction){
		List<Employee> sortedEmp = new ArrayList<Employee>();
		sortedEmp = this.employeeRepository.findAll(Sort.by(direction, "firstName"));
		return sortedEmp;
	}
}
