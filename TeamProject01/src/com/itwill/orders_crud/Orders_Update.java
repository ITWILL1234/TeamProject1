package com.itwill.orders_crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Orders_Update {

	public static void main(String[] args) {
		 try (
		            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADMIN", "admin");
		            Statement stmt = conn.createStatement();
		        ) {
		        	String sql = "UPDATE ORDERS SET EMAIL = 'LEEWS2222@GOOGLE.COM' WHERE EMAIL ='example@email.com' ";
				    System.out.println("sql : " + sql);
					int result = stmt.executeUpdate(sql);
					System.out.println("처리건수 : " + result);
		    
		        } catch (SQLException e) {
		            e.printStackTrace();
		            
		        }
		    }
		}