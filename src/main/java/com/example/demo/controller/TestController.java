package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.Details;
import com.example.demo.model.Parent;
import com.example.demo.service.TestService;

@RestController
public class TestController {

	@Autowired
	EmployeeDao employyedao;
	
	static List<Details> savedDetails;
	
	@Autowired
	TestService testServiceImpl;
	
	/*@RequestMapping(value="/savedata")
	public void saveData() {
		
		Parent p=new Parent();
		p.setName("name1");
		
		Address adr=new Address();
		adr.setName("street1");				
		employyedao.saOneTone(adr);
		
		adr.setParentAddress(p);
		employyedao.saOneTone(adr);
	}
	*/
	@RequestMapping(value="/getList")
	public List<Parent> getList() {
		
		Parent p1=new Parent();
		Parent p2=new Parent();
		p1.setId(1);
		p2.setId(2);
		p1.setName("Name1");
		p2.setName("Name2");
		
		List<Parent> list= new ArrayList<Parent>();
		list.add(p1);
		list.add(p2);
		return list;
	}
	
	
	@RequestMapping(value="/savedata", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	//@PostMapping(value="/saveData")
	public List<Details> saveDetails(@RequestBody ArrayList<Details> details) {		
		System.out.println(details);
		savedDetails=details;
		return details;
	}
	
	@RequestMapping(value="/getdata")
	public List<Details> getDetails() {				
		return savedDetails;
	}	
	
	@RequestMapping(value="/transactionExample")
	public void transactionExample() {				
		testServiceImpl.transactionExample();
	}	
}
