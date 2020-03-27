package com.example.demo.dao;

import com.example.demo.model.Address;
import com.example.demo.model.Employee;

public interface EmployeeDao {

	public Object save(Employee employee);
	public Object getEmployee(int id);
	public void saOneTone(Address adr);
}
