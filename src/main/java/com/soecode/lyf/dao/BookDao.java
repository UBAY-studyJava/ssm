package com.soecode.lyf.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.soecode.lyf.entity.Book;

public interface BookDao {

	/**
	 * 通过ID查询单本图书
	 * ID통한 도서조회
	 * @param id
	 * @return
	 */
	Book queryById(long id);

	/**
	 * 查询所有图书
	 * 모든 도서 조회
	 * @param offset 查询起始位置 시작 위치 조회
	 * @param limit 查询条数 조회 건수
	 * @return
	 */
	List<Book> queryAll(@Param("offset") int offset, @Param("limit") int limit);

	/**
	 * 减少馆藏数量 소장수량 감소
	 * 
	 * @param bookId
	 * @return 如果影响行数等于>1，表示更新的记录行数 만약 줄의 수가 >1과 같다면, 갱신된 줄의 수를 표시한다.
	 */
	int reduceNumber(long bookId);

}
