package com.example.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.example.dto.EmployeeDTO;
import com.example.dto.ProjectDTO;

@Entity
public class Employee {

	@Id
	private int empId;
	private String empName;
	private int empSalary;
	private String empSkills;
	private String empEmail;
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}
	public String getEmpSkills() {
		return empSkills;
	}
	public void setEmpSkills(String empSkills) {
		this.empSkills = empSkills;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public EmployeeDTO convertToDTO() {
		EmployeeDTO dto=new EmployeeDTO();
		dto.setEmpId(this.getEmpId());
		dto.setEmpName(this.getEmpName());
		dto.setEmpSalary(this.getEmpSalary());
		dto.setEmpEmail(this.getEmpEmail());
		dto.setEmpSkills(this.getEmpSkills());
		return dto;
	}
}
