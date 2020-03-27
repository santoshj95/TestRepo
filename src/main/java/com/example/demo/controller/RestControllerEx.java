package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.config.CustomProperty;
import com.example.demo.dao.EmployeeDao;
import com.example.demo.model.ExampleBean;
import com.example.demo.service.RestServiceEx;

@RestController
public class RestControllerEx {

	@Autowired
	RestServiceEx service;
	
	@Autowired
	CustomProperty customProp;
	
	EmployeeDao dao;
	
	@RequestMapping("/upload")
	public void uploadFile(@RequestParam("filename") MultipartFile file, @RequestParam("name") String name) {
		
		try {
			byte[] files = file.getBytes();
			System.out.println(files.length);
			
			FileOutputStream fo=new FileOutputStream(new File("C:\\Users\\Santosh\\Documents\\workspace-sts-3.9.4."
					+ "RELEASE\\demo\\src\\main\\resources\\"
					+ name+".pdf"));
			fo.write(files);
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@GetMapping("/download")
	public void download(HttpServletRequest req, HttpServletResponse response) {
		
		try {
			FileInputStream fin=new FileInputStream(new File("C:\\Users\\Santosh\\Documents\\workspace-sts-3.9.4."
					+ "RELEASE\\demo\\src\\main\\resources\\Resume.pdf"));
			System.out.println(fin.available());
			
			response.setContentType("application/pdf");
			response.addHeader("Content-Disposition", "attachment; filename=resume");
			
			   int nRead;
			   while ((nRead = fin.read()) != -1) {
				   int d=nRead;
			       response.getWriter().write(nRead);
			   }
			   fin.close();
		}catch(IOException ie) {
			ie.printStackTrace();
		}				
	}
	
	@GetMapping("/getAvng")
	public List<String> getAvengers(HttpServletRequest req, HttpServletResponse response) {

		/*List<String> list=new ArrayList<>();*/
		try {
						
			System.out.println("*********"+customProp.getProperty());
			return service.getAvengers();
	/*		list.add("Iron man");
			list.add("Thor");
			list.add("Hulk");*/
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return null;		
	}
	
	@PostMapping(path="/mapObject" , consumes= "application/json") 
	public String getBean(@RequestBody ExampleBean bean) {
		System.out.println("sfdsfd");
		return bean.toString();
	}
	
	@GetMapping(path="/rest") 
	public ResponseEntity getBean() {
		System.out.println("sfdsfd");
		List<String> list=new ArrayList<>();			
			list.add("Iron man");
			list.add("Thor");
			list.add("Hulk");			
			return new ResponseEntity<>(list, HttpStatus.CREATED);
		//service.getData();
	}
		
}
