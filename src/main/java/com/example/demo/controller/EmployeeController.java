package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping("/uploadFile")
	public void uploadImage(@RequestParam("filename") MultipartFile file) {
		
		try {
								
			byte[] files = new byte[(int)file.getSize()];
			
			InputStream fis=file.getInputStream();
			fis.read(files);
			
			Employee emp=new Employee();
			emp.setPhoto(files);	
			System.out.println(files.length);
			
			emp.setEmployee_name("d");
			employeeService.save(emp);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@RequestMapping("/getEmp")
	public Object getEmployee(@RequestParam("id") int id) {
		Employee emp = null;
		try {
			emp = (Employee) employeeService.getEmployee(id);
			byte[] image = emp.getPhoto();
			
			FileOutputStream fo=new FileOutputStream(new File("C:\\Users\\Santosh\\Desktop\\demo\\src\\main\\resources\\"
					+ "image"+".PNG"));
			fo.write(image);
			fo.close();
			return emp;
		} catch(Throwable t) {
			t.printStackTrace();
		}
		return emp;
	}
	@RequestMapping("/saveemployee")
	public Object saveEmployee() {
		
		Employee emp=new Employee();
		try {
		//	emp.setId(100);
			emp.setEmployee_name("Test1");
			emp.setEmployee_age("34");
			emp.setEmployee_salary("1000");
			return employeeService.save(emp);
		} catch(Throwable t) {
			t.printStackTrace();
		}
		return null;
	}
}
