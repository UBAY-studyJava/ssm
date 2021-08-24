package com.soecode.lyf.service.impl;

import java.util.List;
import java.util.UUID;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soecode.lyf.dao.UsersDao;
import com.soecode.lyf.entity.Users;
import com.soecode.lyf.service.UsersService;

@Service
public class UserServiceImpl implements UsersService {

	// 注入Service依赖 서비스의존도 주입
	@Autowired
	private UsersDao usersDao;

	
	
	/**
	 * check if user exists
	 * 
	 * @param name
	 * @return 1 if true, 0 if false
	 */
	private boolean checkExist(String name) {
		Users exist = usersDao.selectUser(name);
		if(exist == null) { return false; }
		else { return true; }
	}

	@Override
	public Users getByName(String userName) {
		return usersDao.selectUser(userName);
	}

	@Override
	public List<Users> getListUsers() {
		return usersDao.queryAll();
	}

	@Override
	public int registerNew(Users user) {
		// check if user already exists
		if(checkExist(user.getName())) { return 0; }

		// Salt & Hash password using UUID and SHA256
		String uuid = UUID.randomUUID().toString();
		String pwdPlain = user.getPwd();
		String pwdSalt = DigestUtils.sha256Hex(uuid.subSequence(0, 7) + pwdPlain);
		
		// Set values of user with new values.
		user.setId(uuid);
		user.setPwd(pwdSalt);
		
		int insert = usersDao.insertUser(user.getId(), user.getName(), user.getPwd());
		
		return insert;
	}
	
	@Override
	public int checkUserLogin(Users user) {
		// check if user already exists
		if(checkExist(user.getName()) == false) { return 1; }
		
		//compares char arrays
		Users compUser = usersDao.selectUser(user.getName());
		String pwdInc = DigestUtils.sha256Hex(compUser.getId().subSequence(0, 7) + user.getPwd().toString());
		boolean check = pwdInc.equals(compUser.getPwd());
		
		if(check) { return 2; } 
		else { return 0; }
		
	}
	
}
