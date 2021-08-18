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

	List<Users> getAllUsers();
	
	/**
	 * 通过主键查询预约图书记录，并且携带图书实体 메인키를 통한 예약도서 기록 조회 및 도서 실체 휴대
	 * Check the reservation book records with the main key and carry the book offline.
	 * @param user_name
	 * @param regist_date
	 * @return
	 */
	Users queryUser(@Param("user_name") String name);

}
