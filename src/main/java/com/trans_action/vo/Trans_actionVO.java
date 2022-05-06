package com.trans_action.vo;

import java.sql.Timestamp;

public class Trans_actionVO {
	private int id;
	private String user_name;
	private int balance;
	private Timestamp regidate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public Timestamp getRegiDate() {
		return regidate;
	}
	public void setRegiDate(Timestamp regidate) {
		this.regidate = regidate;
	}
	
	
}
