package com.soecode.lyf.entity;
import java.util.UUID;

/**
 * 图书实体 도서 (엔티티)서브스턴스
 */
public class Users {

	private String userId;// 图书ID

	private String name;// 图书名称

	private String pwd;// 馆藏数量 소장수량

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
