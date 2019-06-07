package com.example.dbtest.iservice;
import java.util.List;
import java.util.Optional;

import com.example.dbtest.dto.EmployeeDTO;
import com.example.dbtest.entity.Employee;

//this is an Interface has all the then
public interface IEmployeeService {

	Employee save(EmployeeDTO e);
	
	EmployeeDTO findById(long id);
	
	boolean existsById(long id);
	
	List<EmployeeDTO> findAll();
	
	long count();

	void delete(EmployeeDTO entity);
	
	void deleteById(long id);

	void deleteAll();

}
