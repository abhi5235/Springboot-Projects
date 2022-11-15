package com.example.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.example.entity.Employee;

public class EmployeeRequestDTO {

	@Max(value = 2000,message = "Employee id can max 2000")
	@Min(value = 10,message = "Employee id can min 10")
	private int empId;
	@NotBlank(message = "name cannot be blank")
	private String empName;
	private int empSalary;
	private String empSkills;
	@Email(message = "Email is invalid")
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

	public Employee convertToEntity() {
		Employee employee = new Employee();
		employee.setEmpId(this.getEmpId());
		employee.setEmpEmail(this.getEmpEmail());
		employee.setEmpName(this.getEmpName());
		employee.setEmpSalary(this.getEmpSalary());
		employee.setEmpSkills(this.getEmpSkills());
		return employee;

	}
}
