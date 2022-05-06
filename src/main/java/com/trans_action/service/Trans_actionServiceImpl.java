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
		
		int balance = trans_actionDAO.getBalance(sender); //보내는 사람 잔액 체크
		
		if(balance >= money) { //보내는 돈이 잔액보다 많으면
			trans_actionDAO.transfer(sender, receiver, money);
			
		} else {
				System.out.println("잔액이 부족합니다");
				//throw new NoMoneyException();
		}
	}
}
