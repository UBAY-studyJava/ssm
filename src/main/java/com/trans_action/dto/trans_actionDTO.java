package com.trans_action.dto;

public class trans_actionDTO {
	private String user_name;
	private int balance;
	private String regidate;
	private String account_number;
	
	
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
	public String getRegidate() {
		return regidate;
	}
	public void setRegidate(String regidate) {
		this.regidate = regidate;
	}
	public String getAccount_number() {
		return account_number;
	}
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
	}
	
	
	@Override
	public String toString() {
		return "Trans_action [user_name =" + user_name + ", balance="+ balance + ", account_number="+ account_number + ", regidate =" + regidate + "]";
	}
	
}
