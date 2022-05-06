package com.soecode.lyf.entity;

public class Product {

		private int productId;
		private String productName;
		private String productDetail;
		private int cash;
		private int balance;
		private String account_number;
	
		
		public int getProductId() {
			return productId;
		}
	
	
		public void setProductId(int productId) {
			this.productId = productId;
		}
	
	
		public String getProductName() {
			return productName;
		}
	
	
		public void setProductName(String productName) {
			this.productName = productName;
		}
	
	
		public String getProductDetail() {
			return productDetail;
		}
	
	
		public void setProductDetail(String productDetail) {
			this.productDetail = productDetail;
		}
	
	
		public int getCash() {
			return cash;
		}
	
	
		public void setCash(int cash) {
			this.cash = cash;
		}
	
	
		public int getBalance() {
			return balance;
		}
	
	
		public void setBalance(int balance) {
			this.balance = balance;
		}
	
	
		public String getAccount_number() {
			return account_number;
		}
	
	
		public void setAccount_number(String account_number) {
			this.account_number = account_number;
		}
	
	
		@Override
		public String toString() {
			return "Product [ProductId=" + productId + ", productName=" + productName + ", productDetail=" + productDetail +", cash=" + cash +", balance=" + balance +", account_number=" + account_number + "]";
		}
	
	
	}
