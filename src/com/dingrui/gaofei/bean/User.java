package com.dingrui.gaofei.bean;

public class User {
	
	private String user_name;
	private String user_passwd;
	private int user_grade ;
	public User()
	{
		
	}
	public User(String user_name, String user_passwd,int user_grade)
	{
		super();
		this.user_name = user_name;
		this.user_passwd = user_passwd;
		this.user_grade = user_grade;
		
	}
	
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_passwd() {
		return user_passwd;
	}
	public void setUser_passwd(String user_passwd) {
		this.user_passwd = user_passwd;
	}
	public int getUser_grade() {
		return user_grade;
	}
	public void setUser_grade(int user_grade) {
		this.user_grade = user_grade;
	}

}
