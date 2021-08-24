package com.soecode.lyf.dao;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.Users;
import java.util.List;

public interface UsersDao {

	/**
	 * Insert User
	 * 
	 * @param user_id
	 * @param user_name
	 * @param user_pwd
	 * @return Number of rows inserted
	 */
	int insertUser(@Param("user_id") String id, @Param("user_name") String name, @Param("user_pwd") String pwd);

	/**
	 * Get a full list of all existing user's user_name
	 * @param user_name
	 * @return
	 */
	List<Users> queryAll();
	
	/**
	 * Gets the full detail of a single user by their user_name
	 * @param user_name
	 * @return
	 */
	Users selectUser(@Param("user_name") String name);

}
