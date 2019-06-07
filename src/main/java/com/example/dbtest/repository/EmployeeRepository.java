package com.example.dbtest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dbtest.entity.Employee;


/*this class is connected to JDBC. Repository class is the connection object for the entity, 
'coz in the backend the repository is using JDBC
- For database operations we use through repository class
Use Inferitance */

@Repository
public interface EmployeeRepository extends CrudRepository <Employee, Long>{
	
}
