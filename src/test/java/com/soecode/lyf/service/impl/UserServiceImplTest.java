package com.soecode.lyf.service.impl;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.soecode.lyf.BaseTest;
import com.soecode.lyf.entity.Users;
import com.soecode.lyf.service.UsersService;

public class UserServiceImplTest extends BaseTest {

	@Autowired
	private UsersService userService;
	
	Users testUser = new Users("test2", "test2");

	@Test
	public void testRegisterNew() throws Exception {
		
		System.out.println("name=" + testUser.getName());
		System.out.println("pwd=" + testUser.getPwd());
		
		int result = userService.registerNew(testUser);
		
		System.out.println("new user count: " + result);
	}

	
	@Test
	public void testCheckUserLogin() throws Exception {

		System.out.println("name=" + testUser.getName());
		System.out.println("pwd=" + testUser.getPwd());
		
		int result = userService.checkUserLogin(testUser);
		
		
		
		System.out.println("Does user exist? " + result);
	}
}
