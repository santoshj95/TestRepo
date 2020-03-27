package com.example.demo.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Address;
import com.example.demo.model.Child;
import com.example.demo.model.ManyToOneCh;
import com.example.demo.model.ManyToOnePr;
import com.example.demo.model.Parent;

@Repository
@Transactional
public class PersonDaoImpl implements PersonDao{

	@Autowired
	SessionFactory fc;
	
	public Object getPerson() {	     
		
	Parent p=new Parent();
	p.setName("s");
	
	Child c1=new Child();
	c1.setName("c1");
	c1.setParentColumn(p);
	Child c2=new Child();
	c2.setName("c2");
	c2.setParentColumn(p);
	
	ArrayList<Child> list=new ArrayList<Child>();
	list.add(c1);
	list.add(c2);
	
	Address sdr=new Address();
	sdr.setName("kop");
	sdr.setParentAddress(p);
	
	p.setChild(list);
	p.setParentAddress(sdr);
	Serializable id = fc.getCurrentSession().save(p);
	return fc.getCurrentSession().get(Parent.class,id);
	/*Vendor v=new Vendor();
    v.setVendorId(130);
    v.setVendorName("java4s");

    Customers c1=new Customers();
    c1.setCustomerId(400);
    c1.setCustomerName("customer1");

    Customers c2=new Customers();
    c2.setCustomerId(401);
    c2.setCustomerName("customer2");

    Set s=new HashSet();
    s.add(c1);
    s.add(c2);

    v.setChildren(s);*/    
}
	@Override
	@Transactional
	public Object getPersons() {
		Serializable kid=32;
		Parent parent = (Parent)fc.getCurrentSession().get(Parent.class,kid);
		Parent t=new Parent();
		t.setId(parent.getId());
		t.setName(parent.getName());
		Address parentAddress=new Address();
		parentAddress.setId(parent.getParentAddress().getId());
		parentAddress.setName(parent.getParentAddress().getName());		
		t.setParentAddress(parentAddress);
		return t;
				//fc.getCurrentSession().get(Parent.class, kid);
	}
	
	@Override
	@Transactional
	public Object getPersonsMany() {
		
		ManyToOnePr f1=new ManyToOnePr();
			f1.setString("ManyToOnePr1");
		ManyToOnePr f2=new ManyToOnePr();
			f2.setString("ManyToOnePr2");
		List<ManyToOnePr> first=new ArrayList<ManyToOnePr>();
		first.add(f1);
		first.add(f2);
		
		ManyToOneCh s1=new ManyToOneCh();
			s1.setString("ManyToOneCh1");
		ManyToOneCh s2=new ManyToOneCh();
			s2.setString("ManyToOneCh2");
		
		List<ManyToOneCh> second=new ArrayList<ManyToOneCh>();
		second.add(s1);
		second.add(s2);
		
		f1.setManyToOneCh(second);
		f2.setManyToOneCh(second);
		
		fc.getCurrentSession().save(f1);
		fc.getCurrentSession().save(f2);
		
		return fc;
				//fc.getCurrentSession().get(Parent.class, kid);
	}
}
