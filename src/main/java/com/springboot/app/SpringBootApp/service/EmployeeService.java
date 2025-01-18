package com.springboot.app.SpringBootApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.app.SpringBootApp.dao.EmployeeRepository;
import com.springboot.app.SpringBootApp.model.EmployeeModel;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	

	public List<EmployeeModel> getAllEmployees() {

		return repository.findAll();

	}

	public List<EmployeeModel> addEmployee(EmployeeModel employeeModel) {

		repository.save(employeeModel);
		return getAllEmployees();

	}

	public List<EmployeeModel> deleteEmployee(String employeeId) {
		repository.deleteById(Long.parseLong(employeeId));
		return getAllEmployees();

	}

	public List<EmployeeModel> updateEmployee(EmployeeModel employeeModel) {
		repository.save(employeeModel);
		return getAllEmployees();

	}

}
