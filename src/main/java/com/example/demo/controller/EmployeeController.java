package com.example.demo.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	public Object getEmp(@RequestParam("id") int id) {
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
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/getEmployee")
	public Object getEmployee(@RequestParam("id") int id) {
		Employee emp = null;
		try {
			
			return listEmployee.get(id);
			/*emp = (Employee) employeeService.getEmployee(id);			
			return emp;*/
		} catch(Throwable t) {
			t.printStackTrace();
		}
		return emp;
	}
	
	static List<Employee> listEmployee = new ArrayList<Employee>();
	static int i=0;
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/saveemployee", method=RequestMethod.POST, consumes="application/json", produces="application/json")
	public Object saveEmployee(@RequestBody Employee emp) {

		Employee savedEmp =null;
		try {
			System.out.println("Employee : "+ emp);
			emp.setId(i);
				
			//int i = 10/0; // Test exception
			listEmployee.add(emp);
			savedEmp =listEmployee.get(i);
			i++;
		} catch(Exception ex) {
			Map<String,Object> message= new HashMap<String,Object>();			
			message.put("Custom_Message", "Exception while save employee..");
			message.put("Message", ex.getMessage());			
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEmp);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/getEmployeeList")
	public List<Employee> getList() {
		return listEmployee;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/updateEmployee")
	public Object updateEmployee(@RequestBody Employee employee) {	
		System.out.print(employee);
		return null;
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/deleteEmployee")
	public Object deleteEmployee(@RequestParam("id") int id) {	
		System.out.print(id);
		return HttpStatus.OK;
	}
}
