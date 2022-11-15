package com.example.dto;

public class EmployeeDTO {

	private int empId;
	private String empName;
	private int empSalary;
	private String empSkills;
	private String empEmail;
	private ProjectDTO project;
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
	public ProjectDTO getProject() {
		return project;
	}
	public void setProject(ProjectDTO project) {
		this.project = project;
	}
}
