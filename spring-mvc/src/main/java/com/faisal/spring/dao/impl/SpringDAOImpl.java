package com.faisal.spring.dao.impl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.faisal.spring.dao.inf.SpringDAOInf;
import com.faisal.spring.entity.Employee;

@Repository
@Transactional
public class SpringDAOImpl implements SpringDAOInf {
	private static Log log = LogFactory.getLog(SpringDAOImpl.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployee() {
		return  sessionFactory.getCurrentSession().createQuery("from Employee").getResultList();
	}

	public Employee saveEmp(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
		log.info(emp);
		return emp;
	}
}
