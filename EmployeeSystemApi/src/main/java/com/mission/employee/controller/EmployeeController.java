package com.mission.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mission.employee.entity.EmployeeEntity;
import com.mission.employee.model.EmployeeModel;
import com.mission.employee.services.EmployeeService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employees")
	public EmployeeModel createEmployee(@RequestBody EmployeeModel employee) {
		return employeeService.createEmployee(employee);
	}
	
	@GetMapping("/employees")
	public List<EmployeeModel> getAllEmployess(){
		return employeeService.getAllEmployeees();
		
		
	}
	
	@DeleteMapping("/employees/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteEmployess(@PathVariable Long id){
		boolean deleted = false;
		
		deleted = employeeService.deleteEmployee(id);
		
		Map<String, Boolean> resposne = new HashMap<>();
		
		resposne.put("deleted", deleted);
		
		return ResponseEntity.ok(resposne);		
		
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<EmployeeModel> getEmployeeById(@PathVariable Long id) {
		
		EmployeeModel employeeModel = null;
		
		employeeModel = employeeService.getEmployeeById(id);
		
		return ResponseEntity.ok(employeeModel);		
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<EmployeeModel> updateEmployee(@PathVariable Long id,@RequestBody EmployeeModel employee ) {
		
		EmployeeModel employeeModel = null;
		
		employeeModel = employeeService.updateEmployee(id,employee);
		
		return ResponseEntity.ok(employeeModel);		
	}
	
	
	
	
	
}
