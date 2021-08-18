package com.soecode.lyf.service;

import java.util.List;

import com.soecode.lyf.dto.AppointExecution;
import com.soecode.lyf.entity.Book;
import com.soecode.lyf.entity.Users;

/**
 * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 * 업무 인터페이스: "사용자" 각도 설계 
 * 인터페이스의 세 가지 측면: 방법 정의 입도, 파라미터, 되돌리기 유형(리턴 타입/이상)
 */
public interface UsersService {

	/**
	 * look up user by name
	 * 
	 * @param bookId
	 * @return
	 */
	Users getByName(String userName);

	/**
	 * Look up all users
	 * 
	 * @return
	 */
	List<Users> getAll();

}
