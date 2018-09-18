package com.faisal.spring.dao.inf;

import java.util.List;

import com.faisal.spring.entity.Employee;

public interface SpringDAOInf {
	public List<Employee> getEmployee();

	public Employee saveEmp(Employee e);
}
