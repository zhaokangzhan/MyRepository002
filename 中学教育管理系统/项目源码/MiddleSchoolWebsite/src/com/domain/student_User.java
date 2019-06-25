package com.domain;

public class student_User {
    private int id;
    private int ordernum;
    private String unique_id;
	private String name;
	private String password;
	private String sex;
	private String idcard_number;
	private String phonenumber;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUnique_id() {
		return unique_id;
	}
	public void setUnique_id(String unique_id) {
		this.unique_id = unique_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getIdcard_number() {
		return idcard_number;
	}
	public void setIdcard_number(String idcard_number) {
		this.idcard_number = idcard_number;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public int getOrdernum() {
		return ordernum;
	}
	public void setOrdernum(int ordernum) {
		this.ordernum = ordernum;
	}
}
