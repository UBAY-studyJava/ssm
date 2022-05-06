package com.trans_action.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trans_action.dto.trans_actionDTO;

@Repository //해당 클래스를 bean으로 등록	
public class Trans_actionRepositoryImpl implements Trans_actionRepository {
	
	private String namespace = "com.trans_action.mapper.Trans_actionmapper"; //mapper 파일의 namespace + "."
	
	@Autowired
	SqlSession session;
	
	@Override
	public int insertTrans_action(trans_actionDTO trans_action) {
		return session.insert(namespace + "insertTrans_action", trans_action); //return 형태: session.{id의 태그명}(namespace + {namespace에 속하는 mapper의 id}, {parameterType})
	}
	
	@Override
	public List<trans_actionDTO> selectTrans_action() {
		return session.selectList(namespace + "selectTrans_action"); //selectList는 조회되는 값을 모두 불러와 List에 저장, selectOne은 조회되는 값 하나만 저장
	
	}
}
