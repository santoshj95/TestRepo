package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.dao.TestDao;
import com.example.demo.dao.TestDaoImpl;
import com.example.demo.model.Address;
import com.example.demo.model.Parent;

@SpringBootApplication
@EnableTransactionManagement 
//(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages= {"com.example.demo.*"})
public class DemoApplication {

	public static void main(String[] args) {
		
		System.out.println();
	/*	try {
			FileInputStream fis=new FileInputStream(new File("C:\\Users\\Santosh\\Documents\\workspace-sts-3.9.4.RELEASE\\demo\\src\\main\\resources\\example.properties"));
			Properties prop=new Properties();
			try {
				prop.load(fis);
				System.out.println("**********"+prop.getProperty("key"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		SpringApplication.run(DemoApplication.class, args);				
	}
}
