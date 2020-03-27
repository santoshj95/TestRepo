package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="address")
public class Address {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	@Column(name="name")
	private String name;
	@OneToOne
	@JoinColumn(name="parent_id")
	private Parent parent;
	
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
	public Parent getParentAddress() {
		return parent;
	}
	@com.fasterxml.jackson.annotation.JsonIgnore
	public void setParentAddress(Parent parentAddress) {
		this.parent = parentAddress;
	}
}
