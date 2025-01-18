package com.springboot.app.SpringBootApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.springboot.app.SpringBootApp.model.EmployeeModel;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }, scanBasePackages={
"com.springboot.app.SpringBootApp.dao", "com.springboot.app.SpringBootApp"})
public class SpringBootAppApplication {

	public static void main(String[] args) {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		try {
			EmployeeModel employeeModel=new EmployeeModel(); 
			employeeModel.setCreatedBy(Long.parseLong("1"));
			String json = ow.writeValueAsString(employeeModel);
			System.out.println("json"+json);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SpringApplication.run(SpringBootAppApplication.class, args);
	}

}
