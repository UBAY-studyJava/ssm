package com.soecode.lyf.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.Appointment;
import com.soecode.lyf.entity.Book;

public interface AppointmentDao {

	/**
	 * 插入预约图书记录 Insert Reservation Book Records
	 * 
	 * @param bookId
	 * @param studentId
	 * @return Number of rows inserted
	 */
	int insertAppointment(@Param("bookId") long bookId, @Param("studentId") long studentId);

	/**
	 * 通过主键查询预约图书记录，并且携带图书实体 메인키를 통한 예약도서 기록 조회 및 도서 실체 휴대
	 * Check the reservation book records with the main key and carry the book offline.
	 * @param bookId
	 * @param studentId
	 * @return
	 */
	Appointment queryByKeyWithBook(@Param("bookId") long bookId, @Param("studentId") long studentId);
	
	
	/**
	 * 
	 * @return List of appointment
	 */
	List<Appointment> appointAll();

}
