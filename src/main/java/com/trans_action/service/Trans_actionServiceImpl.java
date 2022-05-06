package com.trans_action.service;

import java.sql.SQLException;
import javax.sql.DataSource;
import com.trans_action.dao.Trans_actionDAO;
import com.trans_action.dao.Trans_actionDAOImpl;
import com.trans_action.vo.Trans_actionVO;

public class Trans_actionServiceImpl implements Trans_actionService {
	
	private Trans_actionDAO trans_actionDAO;
	private DataSource ds = null;
	
	public Trans_actionServiceImpl(DataSource ds) {
		
		trans_actionDAO = new Trans_actionDAOImpl(ds);
		this.ds = ds;
	}
	
	@Override 
	public void accountCreate(Trans_actionVO vo) throws SQLException {
		trans_actionDAO.create(vo);
	}
	
	public void accountTransfer(String sender, String receiver, int money) throws SQLException {
		
		int balance = trans_actionDAO.getBalance(sender); //������ ��� �ܾ� üũ
		
		if(balance >= money) { //������ ���� �ܾ׺��� ������
			trans_actionDAO.transfer(sender, receiver, money);
			
		} else {
				System.out.println("�ܾ��� �����մϴ�");
				//throw new NoMoneyException();
		}
	}
}
