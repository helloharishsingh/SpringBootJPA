package com.springboot.app.SpringBootApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.springboot.app.SpringBootApp.model.EmployeeModel;
import com.springboot.app.SpringBootApp.service.EmployeeService;


@RestController
@RequestMapping("/employee/api")
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	
	@GetMapping("/")
	public ResponseEntity<List<EmployeeModel>> getAllEmployees() {
		try {
			List<EmployeeModel> employeeList = service.getAllEmployees();
			if (!CollectionUtils.isEmpty(employeeList))
				return new ResponseEntity<>(employeeList, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PostMapping("/")
	public ResponseEntity<List<EmployeeModel>> addEmployees(@RequestBody EmployeeModel employeeModel) {
		try {
			List<EmployeeModel> employeeList = service.addEmployee(employeeModel);
			if (!CollectionUtils.isEmpty(employeeList))
				return new ResponseEntity<List<EmployeeModel>>(employeeList, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@PutMapping("/")
	public ResponseEntity<List<EmployeeModel>> updateEmployee(@RequestBody EmployeeModel employeeModel) {
		try {
			List<EmployeeModel> employeeList = service.updateEmployee(employeeModel);
			if (!CollectionUtils.isEmpty(employeeList))
				return new ResponseEntity<List<EmployeeModel>>(employeeList, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{employeeId}")
	public ResponseEntity<List<EmployeeModel>> deleteEmployee(@PathVariable String employeeId) {
		try {
			List<EmployeeModel> employeeList = service.deleteEmployee(employeeId);
			if (!CollectionUtils.isEmpty(employeeList))
				return new ResponseEntity<List<EmployeeModel>>(employeeList, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
