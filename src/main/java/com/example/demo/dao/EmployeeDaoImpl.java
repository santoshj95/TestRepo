package com.example.demo.dao;

import java.io.Serializable;
import java.util.Base64;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Address;
import com.example.demo.model.Employee;

@Repository
@EnableTransactionManagement 
public class EmployeeDaoImpl implements EmployeeDao {

	@Autowired
	private SessionFactory sessionfactory;
	
	/*@Autowired
	HibernateTransactionManager hibernateTransactionManager;
	*/
	@Override
	@Transactional(transactionManager="hibernateTransactionManager", isolation=Isolation.SERIALIZABLE,rollbackFor=Exception.class) // specify transaction manager	
	public Object save(Employee employee) {
		try {			
			Integer employeeId = (Integer)sessionfactory.getCurrentSession().save(employee);
			int i=10/0;			
			Employee emp = (Employee)sessionfactory.getCurrentSession().get(Employee.class, employeeId);
			System.out.println(emp);			
			return emp;
		} catch( Throwable t) {
			t.printStackTrace();
		}
	return null;	
	}
	
	@Transactional
	public Object getEmployee(int id) {
		try {
			Employee emp = sessionfactory.getCurrentSession().get(Employee.class, (Serializable)id);
			emp.setPhoto(Base64.getEncoder().encode(emp.getPhoto()));
			return emp;
		}catch(Throwable t) {
		t.printStackTrace();	
		}
		return null;
	}
	
	@Override
	@Transactional
	public void saOneTone(Address adr) {
		Session session = sessionfactory.getCurrentSession();
		session.save(adr);
	}
}
