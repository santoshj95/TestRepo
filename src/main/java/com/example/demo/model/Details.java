package com.example.demo.model;

public class Details {

	private String detail1;
	private String detail2;
	private String detail3;
	
	Details(){}
	
	Details(String detail1,String detail2,String detail3) {
		this.detail1=detail1;
		this.detail2=detail2;
		this.detail3=detail3;
	}
	
	

	@Override
	public String toString() {
		return "Details [detail1=" + detail1 + ", detail2=" + detail2 + ", detail3=" + detail3 + "]";
	}

	public String getDetail1() {
		return detail1;
	}

	public void setDetail1(String detail1) {
		this.detail1 = detail1;
	}

	public String getDetail2() {
		return detail2;
	}

	public void setDetail2(String detail2) {
		this.detail2 = detail2;
	}

	public String getDetail3() {
		return detail3;
	}

	public void setDetail3(String detail3) {
		this.detail3 = detail3;
	}
}
