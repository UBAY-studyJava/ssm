package com.trans_action.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import com.trans_action.common.JDBCUtil;
import com.trans_action.vo.Trans_actionVO;

//Transaction - 자바
public class Trans_actionDAOImpl implements Trans_actionDAO {
	private final String CREATE_ACCOUNT = "insert into trans_action"
	+ "(user_name, balance, regidate) values(?,?,?)";
	
	private final String SELECT_BALANCE = "select * from trans_action where user_name = ?";
	
	private final String UPDATE_MINUS = "update trans_action set balance = (select balance from trans_action where user_name = ?) - ?" 
	+ "where user_name=?";
	
	private final String UPDATE_PLUS = "update trans_action set balance = (select balance from trans_action where user_name = ?) + ?"
	+ "where user_name = ?";
	
	private DataSource ds = null;
	
	public Trans_actionDAOImpl(DataSource ds) {
		this.ds = ds;
	}
	
	//단일 쿼리에서의 트랜젝션 방법
	@Override
	public void create(Trans_actionVO vo) throws SQLException {
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			conn.setAutoCommit(false); //트랜젝션 시작
			
			pstmt = conn.prepareStatement(CREATE_ACCOUNT);
			pstmt.setString(1, vo.getUser_name());
			pstmt.setInt(2, vo.getBalance());
			pstmt.setTimestamp(3, vo.getRegiDate());
			
			pstmt.executeUpdate();
			
			conn.commit();
		} catch(SQLException e) {
			conn.rollback();
			e.getMessage();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	@Override
	public int getBalance(String user_name) throws SQLException {
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		int result = 0;
		
		try {
			conn.setAutoCommit(false); //트랜젝션 시작
			pstmt = conn.prepareStatement(SELECT_BALANCE);
			
			pstmt.setString(1, user_name);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(3);
			}
			
			conn.commit();
			
			} catch(SQLException e) {
				
				conn.rollback();
				e.getMessage();
				
			} finally {
				JDBCUtil.close(pstmt, conn);	
			}
		
			return result;
	}
	
	
	@Override
	public void plus(String user_name, int money) throws SQLException {
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = null;
		
		try {
			conn.setAutoCommit(false);
			
		// plus,minus 다 확인 후에 commit 처리해야 함
		// 그래서 지금 바로 트랜젝션을 구현하면 안 됨
		pstmt = conn.prepareStatement(UPDATE_PLUS);
		pstmt.setString(1, user_name);
		pstmt.setInt(2, money);
		pstmt.setString(3, user_name);
		
		pstmt.executeUpdate();
		 System.out.println(money);
		conn.commit();
		
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			conn.rollback();
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	@Override
	public void minus(String user_name, int money) throws SQLException {
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = null;
		
		try {
		
		conn.setAutoCommit(false);
		
			//예외 발생시키기(트랜젝션 의도적 발생)
			if(true) {
				throw new SQLException();	//의도적 예외 발생
			}
			
		//plus, minus 다 확인 후에 commit 처리해야 함
		//그래서 지금 바로 트랜젝션을 구현 하면 안 됨
		pstmt = conn.prepareStatement(UPDATE_MINUS);
		pstmt.setString(1, user_name);
		pstmt.setInt(2, money);
		pstmt.setString(3, user_name);
		
		pstmt.executeUpdate();
		
		conn.commit();
		
		} catch(SQLException e) {
			conn.rollback();
			System.out.println(e.getMessage());
		
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
	
	@Override
	public void transfer(String sender, String receiver, int money) throws SQLException {
		Connection conn = ds.getConnection();
		PreparedStatement pstmt = null;
		
		try {
		
		conn.setAutoCommit(false);
		/*
		 * 예외 발생시키기(트랜젝션 의도적 발생)
		 * if(true) {
		 * throw new SQLException();	//의도적 예외 발생
		 * }
		 */
		
		//plus, minus 다 확인 후에 처리해야 함
		//그래서 지금 바로 트랜젝션을 구현하면 안 됨
		
		pstmt = conn.prepareStatement(UPDATE_MINUS);
		
		//주는 사람
		pstmt.setString(1, sender);
		pstmt.setInt(2, money);
		pstmt.setString(3, sender);
		
		pstmt.executeUpdate();
		
		//받는 사람
		pstmt = conn.prepareStatement(UPDATE_PLUS);
		pstmt.setString(1, receiver);
		pstmt.setInt(2, money);
		pstmt.setString(3, receiver);
		
		pstmt.executeUpdate();
		
		conn.commit();
		
		} catch(SQLException e) {
			conn.rollback();
			System.out.println(e.getMessage());
			
		} finally {
			JDBCUtil.close(pstmt, conn);
		}
	}
}
