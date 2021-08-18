package com.soecode.lyf.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.soecode.lyf.dao.UsersDao;
import com.soecode.lyf.entity.Users;
import com.soecode.lyf.service.UsersService;

@Service
public class UserServiceImpl implements UsersService {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	// 注入Service依赖 서비스의존도 주입
	@Autowired
	private UsersDao usersDao;


	@Override
	public Users getByName(String userName) {
		return usersDao.queryUser(userName);
	}

	@Override
	public List<Users> getAll() {
		return usersDao.getAllUsers();
	}

}
