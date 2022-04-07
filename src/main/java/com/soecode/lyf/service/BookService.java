package com.soecode.lyf.service;

import java.util.List;

import com.soecode.lyf.dto.AppointExecution;
import com.soecode.lyf.entity.Appointment;
import com.soecode.lyf.entity.Book;

/**
 * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）취입구 : 「사용자」각도 취입구 3⑤측면 : 방법정취도, 참수, 반회취형(return 취입형/취입)
 */
public interface BookService {

	/**
	 * 查询一本图书 도서 한 권 조회
	 * 
	 * @param bookId
	 * @return
	 */
	Book getById(long bookId);

	/**
	 * 查询所有图书 모든 도서 조회
	 * 
	 * @return
	 */
	List<Book> getList();

	/**
	 * 预约图书 예약 도서
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
	
	/**
	 * delete Book Details
	 * 
	 * @param bookId
	 * @return Number of rows delete
	 */
	int delete(long bookId);

	/**
	 * 
	 * @return List of appointment
	 */
	List<Appointment> getAppointment();

	/**
	 * 
	 * @param name
	 * @param number
	 * @return Number of rows inserted
	 */
	int insert(String name, int number);

}