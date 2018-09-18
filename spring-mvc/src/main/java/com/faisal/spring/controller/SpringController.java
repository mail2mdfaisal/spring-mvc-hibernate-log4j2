package com.faisal.spring.controller;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.faisal.spring.entity.Employee;
import com.faisal.spring.service.SpringService;
import static com.faisal.spring.util.URLPattern.*;


@RestController
public class SpringController {
	
	private static Log log = LogFactory.getLog(SpringController.class);
	@Autowired
	private SpringService service;
	
	
	@GetMapping(LISTS)
	public List<Employee> employeeList() {
		log.info("log testing.......");
		return service.getEmployee();
	}
	
	@PostMapping(SAVE)
	public Employee saveEmp(@ModelAttribute Employee e) {
		log.info("save method ");
		log.info(e);
		return service.save(e);
	}
}
