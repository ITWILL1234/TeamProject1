package com.itwill.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.itwill.utils.DBConfig;

public class CUD {
	private static final String DB_URL = DBConfig.getDbUrl();
    private static final String DB_USER = DBConfig.getDbUser();
    private static final String DB_PASS = DBConfig.getDbPassword();

    public static boolean exeUser(String sql, HashMap<Integer, String>pair) {
    	try (
    			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    			PreparedStatement pstmt = conn.prepareStatement(sql);
    			) {
    		
    		for (Map.Entry<Integer, String> entry : pair.entrySet()) {
    			pstmt.setString(entry.getKey(), entry.getValue());
    		}
    		// 요청 처리가 잘 되었을 경우, 해당 값이 1이상이 나오므로 성공 처리.
    		if (pstmt.executeUpdate() > 0) return true;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	// 예외가 발생하였거나, 처리 결과가 0일경우, 실패가 나온다.
    	return false;
    }
    
    public static boolean exeItem(String sql, HashMap<Integer, String>pair) {
    	try (
    			Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
    			PreparedStatement pstmt = conn.prepareStatement(sql);
    			) {
    		
    		for (Map.Entry<Integer, String> entry : pair.entrySet()) {
    			String value = entry.getValue();
    			try {
    				int intValue = Integer.parseInt(value);
    				pstmt.setInt(entry.getKey(), intValue);
    			} catch(NumberFormatException e) {
    				pstmt.setString(entry.getKey(), value);
    			}
    		}
    		
    		// 요청 처리가 잘 되었을 경우, 해당 값이 1이상이 나오므로 성공 처리.
    		if (pstmt.executeUpdate() > 0) return true;
    	} catch (SQLException e) {
    		e.printStackTrace();
    	}
    	// 예외가 발생하였거나, 처리 결과가 0일경우, 실패가 나온다.
    	return false;
    }
}

