package com.soecode.lyf.service;

import java.util.List;

import com.soecode.lyf.dto.Product;

/**
 * 业务接口：站在"使用者"角度设计接口 三个方面：方法定义粒度，参数，返回类型（return 类型/异常）
 * 업무 인터페이스: "사용자" 각도 설계 
 * 인터페이스의 세 가지 측면: 방법 정의 입도, 파라미터, 되돌리기 유형(리턴 타입/이상)
 */
public interface ProductService {

	/**
	 * 查询一本图书 look up a 1 book 도서1권조회
	 * 
	 * @param bookId
	 * @return
	 */
	Product getById(int productId);

	/**
	 * 查询所有图书 모든 도서 조회 look all the books
	 * 
	 * @return
	 */
	List<Product> getList();

	/**
	 * Modify Book Details
	 * 
	 * @param bookId
	 * @param name
	 * @param number
	 * @return Number of rows modified
	 */
	int modify(int productId, String productName, String productDetail, int cash, int balance, int account_number);
	/**
	 * delete Book Details
	 * 
	 * @param bookId
	 * @return Number of rows delete
	 */
	int delete(int productId);

	/**
	 * 
	 * @param name
	 * @param number
	 * @return Number of rows inserted
	 */
	int insert(String name, int number);

	int insert(int productId, String productName, String productDetail, int cash, int balance, int account_number);

}