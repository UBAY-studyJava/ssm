package com.trans_action.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.trans_action.dto.trans_actionDTO;

@Repository //�ش� Ŭ������ bean���� ���	
public class Trans_actionRepositoryImpl implements Trans_actionRepository {
	
	private String namespace = "com.trans_action.mapper.Trans_actionmapper"; //mapper ������ namespace + "."
	
	@Autowired
	SqlSession session;
	
	@Override
	public int insertTrans_action(trans_actionDTO trans_action) {
		return session.insert(namespace + "insertTrans_action", trans_action); //return ����: session.{id�� �±׸�}(namespace + {namespace�� ���ϴ� mapper�� id}, {parameterType})
	}
	
	@Override
	public List<trans_actionDTO> selectTrans_action() {
		return session.selectList(namespace + "selectTrans_action"); //selectList�� ��ȸ�Ǵ� ���� ��� �ҷ��� List�� ����, selectOne�� ��ȸ�Ǵ� �� �ϳ��� ����
	
	}
}
