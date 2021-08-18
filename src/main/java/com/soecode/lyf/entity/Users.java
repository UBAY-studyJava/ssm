package com.soecode.lyf.entity;
import java.util.UUID;

/**
 * User account details
 */
public class Users {

	private String userId;// user id

	private String name;// user name

	private String pwd;// salted password
	
	private String date; // register date
	
	// Constructor
	public Users(String name) {
		this.name = name;
	}
	
	// Getter Setters
	
	public String getId() {
		return userId;
	}
	
	public void setId(String userId) {
		this.userId = userId;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

}
