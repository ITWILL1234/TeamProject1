package com.itwill.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.itwill.user.vo.UserVO;
import com.itwill.page.ConsoleClear;

public class Userr_Delete {
	
	private static UserVO User;
	private static String Password;
	private static String sql = "DELETE FROM USERR WHERE EMAIL = ? ";
	
	private static final int BADREQUEST = 400;
	private static final int NOTFOUND = 404;
	
	public static int deleteUser(UserVO user, String password) {
		// ** ID : ADMIN, PW: admin **  ** 테이블명  USERR  **USE 예약어라 USERR로 설정 **
		resetValue();
		User = user;
		Password = password;
		if (Password.equals(user.getPASSWORD())) {
			return connectDB();
		} else {
			ConsoleClear.clear();
			return BADREQUEST;
		}
    }
	
	private static void resetValue() {
		User = null;
		Password = null;
	}
	
	private static int connectDB() {
        try (
                Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ADMIN", "admin");
                PreparedStatement pstmt = conn.prepareStatement(sql);
            ) {
    		   pstmt.setString(1, User.getEMAIL());
            	return pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
                // 404 에러코드는 예외상황이 발생한 것이므로 특별하게 취급한다.
                return NOTFOUND;
            }
	}
}











