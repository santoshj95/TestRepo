package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ManyToOneTablech")
public class ManyToOneCh {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	public ManyToOneCh() {
	}
	
	@Column
	private String string;
	
	@ManyToMany(mappedBy="manyToOneCh", cascade=CascadeType.ALL)
	private List<ManyToOnePr> manyToOnePr;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<ManyToOnePr> getManyToOnePr() {
		return manyToOnePr;
	}

	public void setManyToOnePr(List<ManyToOnePr> manyToOnePr) {
		this.manyToOnePr = manyToOnePr;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

}
