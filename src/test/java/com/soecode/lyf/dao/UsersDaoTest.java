package com.soecode.lyf.dao;

import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Users;

public class UsersDaoTest extends BaseTest {

	@Autowired
	private UsersDao userDao;

	
	@Test
	public void testQueryAll() throws Exception {
		List<Users> list = userDao.queryAll();
		System.out.println("list=" + list);
	}
	
	@Test
	public void testSelectUser() throws Exception {
		String name = "test";
		Users user = userDao.selectUser(name);
		System.out.println(user);
	}
	
	
//	@Test
//	public void testInsertUser() throws Exception {
//		String id = UUID.randomUUID().toString();
//		String name = "test";
//		String pwd = DigestUtils.sha256Hex(id.subSequence(0, 7)+"test");
//		System.out.println("id=" + id);
//		System.out.println("name=" + name);
//		System.out.println("pwd=" + pwd);
//		int insert = userDao.insertUser(id, name, pwd);
//		System.out.println("insert=" + insert);
//	}



}
