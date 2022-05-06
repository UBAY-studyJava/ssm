package com.trans_action.repository;
import java.util.List;

import com.trans_action.dto.trans_actionDTO;

public interface Trans_actionRepository {
	
	public int insertTrans_action(trans_actionDTO trans_action); // trans_action 데이터 저장 용도
	
	public List<trans_actionDTO> selectTrans_action(); // trans_action 데이터 조회 용도
}