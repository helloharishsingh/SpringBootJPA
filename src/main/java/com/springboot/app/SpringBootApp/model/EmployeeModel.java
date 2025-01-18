package com.springboot.app.SpringBootApp.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;


@Entity(name = "Employee")
public class EmployeeModel {

	@Id
	@GeneratedValue
	private Integer id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String department;
	private double salary;
	private String loginName;
	private String loginPassword;
	private String mobileNumber;
	private String emailId;
	private String role;
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date createdOn;
	private Integer createdBy;
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date updatedOn;
	private Integer updatedBy;
	private String status;
	
	
	
	
	public EmployeeModel() {
		this.createdOn = new Date();
		this.createdBy = 1;
		this.updatedOn = new Date();
		this.updatedBy = 1;
		
	}
	
	@Override
	public String toString() {
		return "EmployeeModel [id=" + id + ", firstName=" + firstName + ", middleName=" + middleName + ", lastName="
				+ lastName + ", department=" + department + ", salary=" + salary + ", loginName=" + loginName
				+ ", loginPassword=" + loginPassword + ", mobileNumber=" + mobileNumber + ", emailId=" + emailId
				+ ", role=" + role + ", createdOn=" + createdOn + ", createdBy=" + createdBy + ", updatedOn="
				+ updatedOn + ", updatedBy=" + updatedBy + ", status=" + status + "]";
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getMiddleName() {
		return middleName;
	}
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public Date getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}
	public Integer getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
