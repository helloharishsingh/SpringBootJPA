package com.springboot.app.SpringBootApp.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.app.SpringBootApp.model.EmployeeModel;
import com.springboot.app.SpringBootApp.service.EmployeeService;

@RestController
@RequestMapping("/admin/api")
public class AdminController {

	@Autowired
	private EmployeeService employeeService;

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

	@PostMapping("/addEmployee")
	public ResponseEntity<List<EmployeeModel>> addEmployees(@RequestBody EmployeeModel employeeModel) {
		try {
			List<EmployeeModel> employeeList = employeeService.addEmployee(employeeModel);
			if (!CollectionUtils.isEmpty(employeeList))
				return new ResponseEntity<List<EmployeeModel>>(employeeList, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/uploadEmployeeByCsv")
	public ResponseEntity uploadEmployeeByCsv(@RequestParam(value = "file") MultipartFile[] files) {
		try {
			for (MultipartFile file : files) {
				employeeService.saveEmployee(file);
			}
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/getAlluploadedEmployees")
	public ResponseEntity<List<EmployeeModel>> getAlluploadedEmployees() {
		try {
			CompletableFuture<List<EmployeeModel>> employeeList = employeeService.getAllEmployee();

			return new ResponseEntity<>(employeeList.get(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/updateEmployee")
	public ResponseEntity<List<EmployeeModel>> updateEmployee(@RequestBody EmployeeModel employeeModel) {
		try {
			List<EmployeeModel> employeeList = employeeService.updateEmployee(employeeModel);
			if (!CollectionUtils.isEmpty(employeeList))
				return new ResponseEntity<List<EmployeeModel>>(employeeList, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteEmployee/{employeeId}")
	public ResponseEntity<List<EmployeeModel>> deleteEmployee(@PathVariable String employeeId) {
		try {
			List<EmployeeModel> employeeList = employeeService.deleteEmployee(employeeId);
			if (!CollectionUtils.isEmpty(employeeList))
				return new ResponseEntity<List<EmployeeModel>>(employeeList, HttpStatus.OK);
			else
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
