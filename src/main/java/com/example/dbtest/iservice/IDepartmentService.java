package com.example.dbtest.iservice;

import java.util.List;
import com.example.dbtest.dto.DepartmentDTO;
import com.example.dbtest.entity.Department;


public interface IDepartmentService {

	Department save(DepartmentDTO e);
	
	DepartmentDTO findById(long id);
	
	boolean existsById(long id);
	
	List<DepartmentDTO> findAll();
	
	long count();

	void delete(DepartmentDTO entity);
	
	void deleteById(long id);

	void deleteAll();
}
