package com.example.dbtest.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dbtest.dto.EmployeeDTO;
//import com.example.dbtest.dto.EmployeeDTO;
import com.example.dbtest.entity.Employee;
import com.example.dbtest.iservice.IEmployeeService;
import com.example.dbtest.repository.EmployeeRepository;

//Business rules are called services. Implement the iservice interface in this class.

@Service
public class EmployeeService implements IEmployeeService {
	
	@Autowired    //to provide dependencies injection (creating an object & providing the object to the class)
	private EmployeeRepository er; 

	@Override
	public Employee save(EmployeeDTO e) {     
		// TODO Auto-generated method stub
		Employee ee= new Employee();
		BeanUtils.copyProperties(e, ee);

		return er.save(ee);
	}

	@Override
	public EmployeeDTO findById(long id) { //when we are not sure about the output like
		// TODO Auto-generated method stub		//the function may return the record if its found else
												//will return null if the record is not found.
		Optional<Employee> ef= er.findById(id); //so we use Optional
		Employee e = ef.get();
		EmployeeDTO pojo= new EmployeeDTO();
		BeanUtils.copyProperties(e, pojo);
		
		return pojo;								//findById- is a select statement which runs internally
	}

	@Override
	public boolean existsById(long id) {
		// TODO Auto-generated method stub
		
		boolean existing= er.existsById(id);
		return existing;
	}

	@Override
	public List<EmployeeDTO> findAll() {
		// TODO Auto-generated method stub
		
		List<Employee> le= (List<Employee>) er.findAll();//its typecasted (converted) to generic value
		List <EmployeeDTO> ldto= new ArrayList <EmployeeDTO>();
		
		for (Employee e:le) { 
			EmployeeDTO pojo= new EmployeeDTO();
			BeanUtils.copyProperties(e, pojo);
			ldto.add(pojo);	
		}
		return ldto;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		
		long ct= er.count();
		return ct;
	}

	@Override
	public void delete(EmployeeDTO e) { // it returns nothing, so no need of variables
		// TODO Auto-generated method stub
		Employee entity= new Employee();
		BeanUtils.copyProperties(e, entity);
		
		er.delete(entity);                //its a function call (pass parameter)
		
	}

	@Override
	public void deleteById(long id) {
		// TODO Auto-generated method stub
		er.deleteById(id);
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		er.deleteAll();
		
	}

}
