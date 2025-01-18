package com.springboot.app.SpringBootApp.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.app.SpringBootApp.dao.EmployeeDao;
import com.springboot.app.SpringBootApp.dao.EmployeeRepository;
import com.springboot.app.SpringBootApp.model.EmployeeModel;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	@Autowired
	private EmployeeDao employeeDao;

	@Async
	public CompletableFuture<List<EmployeeModel>> saveEmployee(MultipartFile file) throws Exception {
		List<EmployeeModel> employeeList = parseCsvFile(file);
		employeeList = repository.saveAll(employeeList);
		return CompletableFuture.completedFuture(employeeList);
	}

	@Async
	public CompletableFuture<List<EmployeeModel>> getAllEmployee() {
		List<EmployeeModel> employeeList = repository.findAll();
		return CompletableFuture.completedFuture(employeeList);
	}

	private List<EmployeeModel> parseCsvFile(MultipartFile file) {
		List<EmployeeModel> employeeList = new ArrayList<EmployeeModel>();
		try {
			try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
				String line;
				EmployeeModel employeeModel = new EmployeeModel();
				while ((line = br.readLine()) != null) {
					String[] strArray = line.split(",");
					employeeModel.setId(Long.parseLong(strArray[0]));
					employeeModel.setName(strArray[1]);
					employeeModel.setMobileNumber(strArray[2]);
					employeeModel.setEmailId(strArray[3]);
					employeeModel.setRole(strArray[4]);
					employeeModel.setCreatedOn(new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH).parse(strArray[5]));
					employeeModel.setCreatedBy(Long.parseLong(strArray[6]));
					employeeModel.setUpdatedOn(new SimpleDateFormat("dd-mm-yyyy", Locale.ENGLISH).parse(strArray[7]));
					employeeModel.setUpdatedBy(Long.parseLong(strArray[8]));
					employeeModel.setStatus(strArray[9]);
					employeeList.add(employeeModel);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employeeList;
	}

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
