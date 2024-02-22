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

    public static boolean exe(String sql, HashMap<Integer, String>pair) {
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
    
	
}

//	public void start() {
//		
//		String sql = "INSERT INTO USERR (EMAIL, PASSWORD, GENDER, FIRST_NAME, LAST_NAME, ADDRESS, CREATE_AT) "
//				   + "VALUES (?, ?, ?, ?, ?, ?, SYSDATE)";
//		
//		// 회원가입 창에서, 유저에게 email, password...와 같은 정볼르 입력받는 코드입니다.
//		SignIn signIn = new SignIn();
//		UserVO user = signIn.exe();
//		
//		// 오라클에 연결하여, 유저 테이블에 인서트를 하기위한 코드입니다.
//        try (
//            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADMIN", "admin");
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//        ) {
//        	pstmt.setString(1, user.getEMAIL());
//        	pstmt.setString(2, user.getPASSWORD());
//        	pstmt.setString(3, user.getGENDER());
//        	pstmt.setString(4, user.getFIRSTNAME());
//        	pstmt.setString(5, user.getLASTNAME());
//        	pstmt.setString(6, user.getADDRESS());
//		   
//        	int result = pstmt.executeUpdate();
//			if (result == 0) {
//				System.out.println("회원가입이 되지 않았습니다! 관리자에게 문의하세요!");
//			} else {
//				// ** 콘솔 화면을 지우고 로그인 페이지로 리디렉션 하는 코드입니다. **
//				ConsoleClear.clear();
//				System.out.println("회원가입이 되었습니다! 로그인을 해주세요!");
//				Login.exe();
//			}
//    
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }