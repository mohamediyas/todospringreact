package com.mission.employee.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mission.employee.entity.EmployeeEntity;
import com.mission.employee.model.EmployeeModel;
import com.mission.employee.repository.EmployeeRepository;


@Service
public class EmployeeServiceImple implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	
	@Override
	public EmployeeModel createEmployee(EmployeeModel employee) {
		// TODO Auto-generated method stub
		
		EmployeeEntity employeeEntity = new EmployeeEntity();
		
		BeanUtils.copyProperties(employee, employeeEntity);
		 
		
		employeeRepository.save(employeeEntity);
		
		return employee;
	}



	@Override
	public List<EmployeeModel> getAllEmployeees() {
		// TODO Auto-generated method stub
		
		List<EmployeeEntity>  employeeEntities = employeeRepository.findAll();
		
		List <EmployeeModel> employess = employeeEntities.stream().map(emp -> new EmployeeModel(
				  emp.getId(),emp.getFirstName(),emp.getLastName(),emp.getEmailId()
				)).collect(Collectors.toList());
		
		
		
		return employess;
	}



	@Override
	public boolean deleteEmployee(Long id) {
		// TODO Auto-generated method stub
		
		EmployeeEntity employee = employeeRepository.findById(id).get();
		
		employeeRepository.delete(employee);
		
		return true;
	}



	@Override
	public EmployeeModel getEmployeeById(Long id) {
		// TODO Auto-generated method stub
		
		EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
		
		EmployeeModel employeeModel = new EmployeeModel();
		
		BeanUtils.copyProperties(employeeEntity, employeeModel);
		
		
		
		return employeeModel;
	}



	@Override
	public EmployeeModel updateEmployee(Long id, EmployeeModel employee) {
		// TODO Auto-generated method stub
		
		EmployeeEntity employeeEntity = employeeRepository.findById(id).get();
		
		employeeEntity.setFirstName(employee.getFirstName());
		employeeEntity.setLastName(employee.getLastName());
		employeeEntity.setEmailId(employee.getEmailId());
		
		employeeRepository.save(employeeEntity);
		
		return employee;
	}

}
