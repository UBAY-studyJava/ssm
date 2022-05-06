package com.trans_action.dao;

import java.sql.SQLException;
import com.trans_action.vo.Trans_actionVO;

public interface Trans_actionDAO {
	// ���� ����
	 public void create(Trans_actionVO vo) throws SQLException;
	 
	 // �ܾ� ��ȸ
	 public int getBalance(String name) throws SQLException;
	 
	 // �÷��� ����
	 public void plus(String name, int money) throws SQLException;
	 
	 // ���̳ʽ� ����
	 public void minus(String name, int money) throws SQLException;
	 
	 // �ŷ�
	 public void transfer(String sender, String receiver, int money) throws SQLException;
	 
}
	

