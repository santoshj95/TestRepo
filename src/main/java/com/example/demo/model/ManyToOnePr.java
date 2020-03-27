package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="ManyToOneTablepr")
public class ManyToOnePr {

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column
	private String string;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="ManyToOneTable_to_child",
			joinColumns= {@JoinColumn(referencedColumnName="id")},
			inverseJoinColumns= {@JoinColumn(referencedColumnName="id")}
	)
	private List<ManyToOneCh> manyToOneCh;
	
	public List<ManyToOneCh> getManyToOneCh() {
		return manyToOneCh;
	}

	public void setManyToOneCh(List<ManyToOneCh> manyToOneCh) {
		this.manyToOneCh = manyToOneCh;
	}

	public ManyToOnePr() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}
}
