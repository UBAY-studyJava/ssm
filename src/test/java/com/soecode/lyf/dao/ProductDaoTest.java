package com.soecode.lyf.dao;

import java.sql.*;
import java.util.List;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.soecode.lyf.dto.Product;
import com.soecode.lyf.BaseTest;

public class ProductDaoTest extends BaseTest {
	
		Connection conn;
		PreparedStatement pstmt;
		ResultSet rs;
		
		public ProductDaoTest() {
			try {
					Class.forName(null);
					conn = DriverManager.getConnection(null);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		public void close() throws SQLException {
			if (rs != null) rs.close();
			if (pstmt != null) pstmt.close();
			if (conn !=null) conn.close();
		}

		public Product queryById1(int productId) {
			// TODO Auto-generated method stub
			return null;
		}

		public List<Product> queryAll(int i, int j) {
			// TODO Auto-generated method stub
			return null;
		}

		public int modifyDetail() {
			// TODO Auto-generated method stub
			return 0;
		}

		public int modifyDetail(int productId, String productName, String productDetail, int cash, int balance,
				int account_number) {
			// TODO Auto-generated method stub
			return 0;
		}

		public int delete(int productId) {
			// TODO Auto-generated method stub
			return 0;
		}

		public int insert(int productId, String productName, String productDetail, int cash, int balance,
				int account_number) {
			// TODO Auto-generated method stub
			return 0;
		}

		public Product queryById(int productId) {
			// TODO Auto-generated method stub
			return null;
		}
}