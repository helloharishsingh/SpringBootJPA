package com.springboot.app.SpringBootApp.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.springboot.app.SpringBootApp.model.EmployeeModel;

@Component
public class EmployeeDao {
	
	private static List<EmployeeModel> employeeList=new ArrayList<EmployeeModel>();
	
	
	public List<EmployeeModel> getAllEmployees(){
		return employeeList;
	}
	
	public List<EmployeeModel> addEmployee(EmployeeModel employeeModel){
		employeeList.add(employeeModel);
		return employeeList;
	}
	
	public List<EmployeeModel> deleteEmployee(String employeeId){
		employeeList=employeeList.stream().filter(emp->emp.getId()!=Long.parseLong(employeeId)).collect(Collectors.toList());
		return employeeList;
	}
	
	public List<EmployeeModel> updateEmployee(EmployeeModel employeeModel){
		employeeList=employeeList.stream().filter(emp->emp.getId()!=employeeModel.getId()).collect(Collectors.toList());
		employeeList.add(employeeModel);
		return employeeList;
	}
	
	
	
}
