package com.springboot.app.SpringBootApp.model;

import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Employee")
public class EmployeeModel {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String loginName;
	private String loginPassword;
	private String mobileNumber;
	private String emailId;
	private String role;
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date createdOn;
	private Long createdBy;
	@JsonFormat(pattern = "dd-mm-yyyy")
	private Date updatedOn;
	private Long updatedBy;
	private String status;
	
	public EmployeeModel(Long id, String name, String mobileNumber, String emailId, String role, 
			Long createdBy,  Long updatedBy, String status) {
		super();
		this.id = id;
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.emailId = emailId;
		this.role = role;
		this.createdOn = new Date();
		this.createdBy = new Long(1);
		this.updatedOn = new Date();
		this.updatedBy = new Long(1);
		this.status = status;
	}
	public EmployeeModel() {
		this.createdOn = new Date();
		this.createdBy = new Long(1);
		this.updatedOn = new Date();
		this.updatedBy = new Long(1);
		
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public Date getUpdatedOn() {
		return updatedOn;
	}
	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	public Long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getStatus() {
		return status;
	}
	public String getLoginPassword() {
		return loginPassword;
	}
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public int hashCode() {
		return Objects.hash(createdBy, createdOn, emailId, id, mobileNumber, name, role, status, updatedBy, updatedOn);
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeeModel other = (EmployeeModel) obj;
		return Objects.equals(createdBy, other.createdBy) && Objects.equals(createdOn, other.createdOn)
				&& Objects.equals(emailId, other.emailId) && Objects.equals(id, other.id)
				&& Objects.equals(mobileNumber, other.mobileNumber) && Objects.equals(name, other.name)
				&& Objects.equals(role, other.role) && Objects.equals(status, other.status)
				&& Objects.equals(updatedBy, other.updatedBy) && Objects.equals(updatedOn, other.updatedOn);
	}
	
}
