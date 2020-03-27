package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.couchbase.client.deps.com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="child")
public class Child {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	int id;
	@Column(name="name")
	private String name;
	@ManyToOne
	@JoinColumn(name="parent_id")
	private Parent parentColumn;

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(int id) {
		this.id = id;
	}

	@com.fasterxml.jackson.annotation.JsonIgnore
	public Parent getParentColumn() {
		return parentColumn;
	}

	public void setParentColumn(Parent parentColumn) {
		this.parentColumn = parentColumn;
	}
	
}
