package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="parent")
public class Parent {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@Column(name="name")
	private String name;
	@OneToMany(mappedBy="parentColumn", cascade=CascadeType.ALL)
	List<Child> child;
	
	@OneToOne(mappedBy="parent", cascade=CascadeType.ALL)
	private Address parentAddress;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Child> getChild() {
		return child;
	}
	public void setChild(List<Child> child) {
		this.child = child;
	}
	public Address getParentAddress() {
		return parentAddress;
	}
	public void setParentAddress(Address parentAddress) {
		this.parentAddress = parentAddress;
	}
	
}
