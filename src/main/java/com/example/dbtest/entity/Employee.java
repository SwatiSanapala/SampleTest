package com.example.dbtest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//this class can only get data from the database(table), no operations can be performed

@Entity //it tell this class is mapped/binded to the database
@Table(name= "employee") // binded to the database with table name= "employee"

public class Employee {
	
	@Id                                               //this id field
	@GeneratedValue(strategy = GenerationType.IDENTITY)  //this field is auto-generated
	@Column(name= "id")       //this field is mapped to column name"id"
	private Long id;          // this is defined for the class
	
	@Column(name="employee_name")
	private String employee_name;
	
	@Column(name= "dept_no")
	private Long dept_no; //after we do the mapping and the class is defined--getters and setters

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
