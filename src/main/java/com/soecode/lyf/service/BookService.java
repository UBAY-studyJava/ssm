package com.soecode.lyf.service;

import java.util.List;

import com.soecode.lyf.dto.AppointExecution;
import com.soecode.lyf.entity.Book;

/**
 * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 * 업무 인터페이스: "사용자" 각도 설계 
 * 인터페이스의 세 가지 측면: 방법 정의 입도, 파라미터, 되돌리기 유형(리턴 타입/이상)
 */
public interface BookService {

	/**
	 * 查询一本图书 look up a 1 book 도서1권조회
	 * 
	 * @param bookId
	 * @return
	 */
	Book getById(long bookId);

	/**
	 * 查询所有图书 모든 도서 조회 look all the books
	 * 
	 * @return
	 */
	List<Book> getList();

	/**
	 * 预约图书 도서예약
	 * 
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	AppointExecution appoint(long bookId, long studentId);

	/**
	 * Modify Book Details
	 * 
	 * @param bookId
	 * @param name
	 * @param number
	 * @return Number of rows modified
	 */
	int modify(long bookId, String name, int number);

}
