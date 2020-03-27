package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.dao.TestDao;
import com.example.demo.model.Address;

@Service
public class TestServiceImpl implements TestService {

	@Autowired
	EmployeeDao testDao;
	
	@Autowired
	TestDao testDaoImpl;
	
	public void saveData(Address adr) {
		testDao.saOneTone(adr);
	}
	
	public void transactionExample() {
		testDaoImpl.transactionExample();
	}
}
