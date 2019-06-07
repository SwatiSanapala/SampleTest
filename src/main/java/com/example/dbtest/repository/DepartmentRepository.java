package com.example.dbtest.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.dbtest.entity.Department;

@Repository
public interface DepartmentRepository extends CrudRepository <Department, Long> {
	
}
