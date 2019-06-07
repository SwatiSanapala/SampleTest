package com.example.dbtest.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dbtest.dto.DepartmentDTO;
import com.example.dbtest.service.DepartmentService;


@RestController
@RequestMapping("/api/")
public class DepartmentAPI {
	
	@Autowired
	public DepartmentService ds;
	
	@CrossOrigin(origins="*") //function level sets the Cors
	@GetMapping ("getDepartments")
	public List <DepartmentDTO> getDepartments() {
		List <DepartmentDTO> lddto= ds.findAll();
				
		return lddto;
}
	
	@CrossOrigin(origins="*") //function level sets the Cors
	@GetMapping ("getDepartment/{id}")
	public  DepartmentDTO getDepartment(@PathVariable long id) {
		DepartmentDTO d= ds.findById(id);
			return d;
	}
	
	@CrossOrigin(origins="*") 
	@PostMapping(value ="addDepartment", headers="Accept=application/json")
	public void addDepartment(@RequestBody DepartmentDTO dd) {
		ds.save(dd);
	}
	
	@CrossOrigin(origins="*")
	@PostMapping(value = "updateDepartment", headers = "Accept=application/json")
	public void updateDepartment(@RequestBody DepartmentDTO d) {	
		ds.save(d); //Employee data with mandatory id 
	}
	
	@CrossOrigin(origins="*")
	@DeleteMapping(value = "deleteDepartmentById/{id}", headers = "Accept=text/plain")
	public void deleteDepartmentById(@PathVariable long id) {	
		System.out.println("attempt to delete.....!");
		ds.deleteById(id); //Employee data with mandatory id 
		System.out.println("check!");
	}
	
	@CrossOrigin(origins="*")
	@DeleteMapping(value = "deleteDepartment", headers = "Accept=application/json")
	public void deleteDepartment(@RequestBody DepartmentDTO d) {	
		ds.delete(d); 
	}
}
