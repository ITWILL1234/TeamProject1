package com.itwill.orders_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Orders_Delete {

	public static void main(String[] args) {
		try (
	            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADMIN", "admin");
	            PreparedStatement pstmt = conn.prepareStatement("DELETE FROM ORDERS WHERE EMAIL ='aaa@email.com'");
	        ) {
			System.out.println("sql : " + pstmt);
        	int result = pstmt.executeUpdate();
			System.out.println("처리건수 : " + result);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}