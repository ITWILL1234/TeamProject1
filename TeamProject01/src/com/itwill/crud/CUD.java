package com.itwill.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.itwill.utils.Config;

public class CUD {
    private static final String DB_URL = Config.getDbUrl();
    private static final String DB_USER = Config.getDbUser();
    private static final String DB_PASS = Config.getDbPassword();

    // DB 작업 수행 공통 로직
    private static boolean exeCUD(String sql, HashMap<Integer, String> pair, boolean useIntForNumbers) {
        try (
            Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
            PreparedStatement pstmt = conn.prepareStatement(sql);
        ) {
            for (Map.Entry<Integer, String> entry : pair.entrySet()) {
                if (useIntForNumbers) {
                    setParameterIntelligently(pstmt, entry);
                } else {
                    pstmt.setString(entry.getKey(), entry.getValue());
                }
            }
            return pstmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // 파라미터 설정 지능화
    private static void setParameterIntelligently(PreparedStatement pstmt, Map.Entry<Integer, String> entry) throws SQLException {
        String value = entry.getValue();
        try {
            int intValue = Integer.parseInt(value);
            pstmt.setInt(entry.getKey(), intValue);
        } catch (NumberFormatException e) {
            pstmt.setString(entry.getKey(), value);
        }
    }

    public static boolean exeUser(String sql, HashMap<Integer, String> pair) {
        return exeCUD(sql, pair, false);
    }

    public static boolean exeItem(String sql, HashMap<Integer, String> pair) {
        return exeCUD(sql, pair, true);
    }
    
    public static boolean exeOrder(String sql, HashMap<Integer, String> pair) {
    	return exeCUD(sql, pair, true);
    }
    
    public static boolean exePost(String sql, HashMap<Integer, String> pair) {
    	return exeCUD(sql, pair, true);
    }
}
