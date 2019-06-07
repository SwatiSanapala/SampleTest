package com.example.dbtest.dto;
//dto- data transfer object. POJO classes

public class EmployeeDTO {
	
	private Long id;
	
	private String employee_name;
	
	private Long dept_no;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public Long getDept_no() {
		return dept_no;
	}

	public void setDept_no(Long dept_no) {
		this.dept_no = dept_no;
	}

	

}
