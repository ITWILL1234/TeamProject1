package com.itwill.orders_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Orders_Insert {

	public static void main(String[] args) {
		try (
	            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADMIN", "admin");
	            PreparedStatement pstmt = conn.prepareStatement("INSERT INTO ORDERS (EMAIL, PRODUCT, ADDRESS, CREATE_AT) VALUES (?, ?, ?, SYSDATE)");
	        ) {
	            // 입력 파라미터 설정 이 부분만 VO로 바꾸면됨
	            pstmt.setString(1, "dddaaa@email.com");
	            pstmt.setString(2, "Product Name");
	            pstmt.setString(3, "Address");
	            int result = pstmt.executeUpdate();
	            System.out.println("처리건수 : " + result);

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}