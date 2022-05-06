package com.trans_action.junit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

// import com.soecode.lyf.service.MemberService;
import com.trans_action.config.RootContext;
import com.trans_action.dto.trans_actionDTO;
import com.trans_action.repository.Trans_actionRepository;

@WebAppConfiguration
@RunWith(SpringRunner.class)
//@ContextConfiguration(locations = {"file:src/main/resources/spring/root-context.xml"}) // xml 방식
@ContextConfiguration(classes = RootContext.class) // java 방식
public class Test_trans_action{
	
	private static Logger logger = LoggerFactory.getLogger(Test_trans_action.class);
	
	@Autowired
	Trans_actionRepository Trans_actionRepositoryImpl;

	@Test
	public void DBTest() {
		trans_actionDTO trans_action = new trans_actionDTO();
		trans_action.setUser_name("kimu");
		trans_action.setBalance(1000);
		trans_action.setAccount_number("123456789");
		trans_action.setRegidate("2022-04-12 14:00");
		System.out.println(trans_action.getUser_name());
		
		
		logger.debug(Trans_actionRepositoryImpl.insertTrans_action(trans_action) + ""); // Cart 데이터 등록
		logger.debug(Trans_actionRepositoryImpl.selectTrans_action().toString()); // Cart 데이터 조회
	}

}