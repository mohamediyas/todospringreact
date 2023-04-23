package com.mission.employee.services;

import java.util.List;

import com.mission.employee.entity.EmployeeEntity;
import com.mission.employee.model.EmployeeModel;

public interface EmployeeService {

	EmployeeModel createEmployee(EmployeeModel employee);

	List<EmployeeModel> getAllEmployeees();

	boolean deleteEmployee(Long id);

	EmployeeModel getEmployeeById(Long id);

	EmployeeModel updateEmployee(Long id, EmployeeModel employee);

}
