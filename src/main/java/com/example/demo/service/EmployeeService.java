package com.example.demo.service;

import com.example.demo.model.Employee;

public interface EmployeeService {

	public Object save(Employee employee);
	public Object getEmployee(int id);
}
