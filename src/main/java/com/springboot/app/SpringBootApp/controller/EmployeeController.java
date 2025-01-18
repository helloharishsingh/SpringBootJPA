package com.springboot.app.SpringBootApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.SpringBootApp.model.EmployeeModel;
import com.springboot.app.SpringBootApp.service.EmployeeService;

//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/employee/api")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	//@PreAuthorize("hasRole('NORMAL')")
	@GetMapping("/getAllEmployees")
	public ResponseEntity<List<EmployeeModel>> getAllEmployees() {
		try {
			List<EmployeeModel> employeeList = employeeService.getAllEmployees();
			if (!CollectionUtils.isEmpty(employeeList))
				return new ResponseEntity<>(employeeList, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
