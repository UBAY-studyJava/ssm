package com.soecode.lyf.entity;
import java.util.UUID;

/**
 * User account details
 */
public class Users {

	private String userId;// user id

	private String name;// user name

	private String pwd;// salted password

	public Users() {
	}

	public Users(String name, String pwd) {
		this.userId = UUID.randomUUID().toString();
		this.name = name;
		this.pwd = pwd;
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

//	@Override
//	public String toString() {
//		return "Book [bookId=" + bookId + ", name=" + name + ", number=" + number + "]";
//	}


}
