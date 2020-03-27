package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeedao;
	@Override
	public Object save(Employee employee) {
		
		Employee emp=new Employee();
		try {
			return employeedao.save(employee);
		} catch(Throwable t) {
			t.printStackTrace();
		}
		return null;
	}
	
	public Object getEmployee(int id) {
		try {
			return employeedao.getEmployee(id);
		} catch(Throwable t) {
			t.printStackTrace();
		}
		return null;
	}
}
