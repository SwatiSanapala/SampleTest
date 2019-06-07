package com.example.dbtest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.dbtest.dto.DepartmentDTO;
import com.example.dbtest.entity.Department;
import com.example.dbtest.iservice.IDepartmentService;
import com.example.dbtest.repository.DepartmentRepository;


@Service
public class DepartmentService implements IDepartmentService {
	
	@Autowired
	private DepartmentRepository dr; 

	@Override
	public Department save(DepartmentDTO d) {
		// TODO Auto-generated method stub
		
		Department dd= new Department();
		BeanUtils.copyProperties(d, dd);
		return dr.save(dd);
	}

	@Override
	public DepartmentDTO findById(long id) {
		// TODO Auto-generated method stub
		
		Optional<Department> df= dr.findById(id); 
		Department d = df.get();
		DepartmentDTO pojo= new DepartmentDTO();
		BeanUtils.copyProperties(d, pojo);
		
		return pojo;						
		
	}

	@Override
	public boolean existsById(long id) {
		// TODO Auto-generated method stub
		boolean existing= dr.existsById(id);
		return existing;
	}

	@Override
	public List<DepartmentDTO> findAll() {
		// TODO Auto-generated method stub
		List<Department> ld= (List<Department>) dr.findAll();//its typecasted (converted) to generic value
		List <DepartmentDTO> lddto= new ArrayList <DepartmentDTO>();
		
		for (Department d:ld) { 
			DepartmentDTO pojo= new DepartmentDTO();
			BeanUtils.copyProperties(d, pojo);
			lddto.add(pojo);	
		}
		return lddto;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		long ct=dr.count();
		return ct;
	}

	@Override
	public void delete(DepartmentDTO d) {
		Department entity= new Department();
		BeanUtils.copyProperties(d, entity);
		
		dr.delete(entity); 
		
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		dr.deleteById(id);
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		dr.deleteAll();
		
	}

}
