package com.faisal.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faisal.spring.dao.inf.SpringDAOInf;
import com.faisal.spring.entity.Employee;

@Service
public class SpringService {
	
	@Autowired
	private SpringDAOInf dao;
	
	public List<Employee> getEmployee() {
		return dao.getEmployee();
	}

	public Employee save(Employee e) {
		return dao.saveEmp(e);
	}

}
