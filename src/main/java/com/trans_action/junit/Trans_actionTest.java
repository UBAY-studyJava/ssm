package com.trans_action.junit;

import static org.junit.jupiter.api.Assertions.*;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.sql.DataSource;
import org.junit.jupiter.api.Test;
import com.trans_action.common.DataSourceFactory;
import com.trans_action.service.Trans_actionService;
import com.trans_action.service.Trans_actionServiceImpl;
import com.trans_action.vo.Trans_actionVO;

class Trans_actionTest {
	@Test
	void test() throws SQLException {
		
		DataSource ds = new DataSourceFactory().getOracleDataSource();
		Trans_actionService service = new Trans_actionServiceImpl(ds);
		
		//1. 계정 생성(계정이 없는 경우라면 주석 풀고 작업하면 됨.
		
		  Trans_actionVO vo = new Trans_actionVO();
		  vo.setUser_name("kimu");
		  vo.setBalance(10000);
		  vo.setRegiDate(Timestamp.valueOf("2022-04-08 14:00"));
		  
		  service.accountCreate(vo);
		  vo.setUser_name("jang");
		  vo.setBalance(0);
		  vo.setRegiDate(Timestamp.valueOf("2022-04-08 15:00"));
		 
		
		//2. 금전 거래
		service.accountTransfer("kimu", "jang", 500);
	}
	
}
