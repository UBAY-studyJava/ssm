package com.trans_action.dao;

import java.sql.SQLException;
import com.trans_action.vo.Trans_actionVO;

public interface Trans_actionDAO {
	// 계좌 생성
	 public void create(Trans_actionVO vo) throws SQLException;
	 
	 // 잔액 조회
	 public int getBalance(String name) throws SQLException;
	 
	 // 플러스 계좌
	 public void plus(String name, int money) throws SQLException;
	 
	 // 마이너스 계좌
	 public void minus(String name, int money) throws SQLException;
	 
	 // 거래
	 public void transfer(String sender, String receiver, int money) throws SQLException;
	 
}
	

