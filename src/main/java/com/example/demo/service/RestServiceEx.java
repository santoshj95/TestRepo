package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.Employee;
import com.example.demo.model.ExampleBean;
import com.google.gson.Gson;

@Service
public class RestServiceEx {
	
	@Autowired
	public ExampleBean bean;
	
	public List<String> getAvengers() {
		
		List<String> list=new ArrayList<>();
		try {
			list.add("Iron man");
			list.add("Thor");
			list.add("Hulk");
			list.add(bean.getUname());			
			//list.add("SpiderMan");
			System.out.println("***********"+bean);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}

		return list;			
	}
	
	public ResponseEntity<String> getData() {
		
			String uri="http://dummy.restapiexample.com/api/v1/employees";
			RestTemplate restTemplate=new RestTemplate();
		    HttpHeaders headers = new HttpHeaders();
		    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
		     
		    ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
		    
		    Gson gson = new Gson();
		    Employee clicks[] = gson.fromJson(result.getBody(), Employee[].class);
		    
		    for(Employee click : clicks)
		    	System.out.println(click.getEmployee_name());
		    return result;
	}

}
