package com.example.dbtest.api;

/*After the service is ready we need to expose the service through RestController so, that the RestController 
is accessible to the entire world- Webservices or API*/

import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.dbtest.dto.EmployeeDTO;
//import com.example.dbtest.entity.Employee;
import com.example.dbtest.service.EmployeeService;
//import java.util.ArrayList;
import java.util.List;
//import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/")

public class EmployeeAPI {
	
	@Autowired
	public EmployeeService es; //create service dependency
	
	@CrossOrigin(origins="*") //function level sets the Cors
	@GetMapping ("getEmployees")
	public List <EmployeeDTO> getEmployees() {
		List <EmployeeDTO> ldto= es.findAll();
				
		return ldto;	
	}

	
	@CrossOrigin(origins="*") //function level sets the Cors
	@GetMapping ("getEmployee/{id}")
	public  EmployeeDTO getEmployee(@PathVariable long id) {
			EmployeeDTO e= es.findById(id);
			return e;
	}
	
	@CrossOrigin(origins="*") 
	@PostMapping(value ="addemployee", headers="Accept=application/json")
	public void addEmployee(@RequestBody EmployeeDTO ed) {
		es.save(ed);
	}
	
	@CrossOrigin(origins="*")
	@PostMapping(value = "updateEmployee", headers = "Accept=application/json")
	public void updateEmployee(@RequestBody EmployeeDTO e) {	
		es.save(e); //Employee data with mandatory id 
	}
	
	@CrossOrigin(origins="*")
	@DeleteMapping(value = "deleteEmployeeById/{id}", headers = "Accept=text/plain")
	public void deleteEmployeeById(@PathVariable long id) {	
		System.out.println("attempt to delete.....!");
		es.deleteById(id); //Employee data with mandatory id 
		System.out.println("check!");
	}
	
	@CrossOrigin(origins="*")
	@DeleteMapping(value = "deleteEmployee", headers = "Accept=application/json")
	public void deleteEmployee(@RequestBody EmployeeDTO e) {	
		es.delete(e); //Employee data with mandatory id 
	}
	
}
