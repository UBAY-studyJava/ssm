package com.trans_action.service;

import java.sql.SQLException;
import com.trans_action.vo.Trans_actionVO;

public interface Trans_actionService {
	
	public void accountCreate(Trans_actionVO vo) throws SQLException;
	public void accountTransfer(String sender, String receiver, int money) throws SQLException;
	
}
