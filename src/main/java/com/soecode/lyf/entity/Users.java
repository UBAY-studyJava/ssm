package com.soecode.lyf.entity;
import java.util.Date;

/**
 * User account details
 * userId, name, pwd, date
 */
public class Users {

	private String id;// user id

	private String name;// user name

	private String pwd;// salted password
	
	private Date date; // register date
	
	// Constructors
	public Users() {
		
	}
	
	public Users(String id, String name, String pwd, Date date) {
		this.id = id;
		this.name = name;
		this.pwd = pwd;
		this.date = date;
	}
	
	// Getter Setters
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "User [id=" + id + 
				" name=" + name + 
				" pwd=" + pwd + 
				" date=" + date + "]";
		
	}
	
}
