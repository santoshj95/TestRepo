package com.example.demo.model;

public class ExampleBean {

	private String uname;
	private String pwd;
	
	public ExampleBean() {
		super();
	}
		
	@Override
	public String toString() {
		return "ExampleBean [uname=" + uname + ", pwd=" + pwd + "]";
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
			
}
