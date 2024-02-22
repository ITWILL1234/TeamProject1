package com.itwill.page;

import java.util.HashMap;

import com.itwill.crud.CUD;
import com.itwill.utils.UserInputScanner;
import com.itwill.vo.UserVO;

public class SignOut {
	private static String PASSWORD;
	private static UserVO USER;
	private static final String SQL = "DELETE FROM USERR WHERE EMAIL = ? ";
	
	public static void exe(UserVO user) {
		USER = null;
		USER = user;
		displayScreen();
		
	    while(true) {
	        System.out.println("회원 탈퇴를 위하여 비밀번호를 입력해 주세요. (취소하려면 'q'를 입력하세요)");

	        PASSWORD = UserInputScanner.scanPassword();

	        // 사용자가 'esc'를 입력했을 경우의 처리
	        if ("q".equals(PASSWORD)) {
	            System.out.println("취소되었습니다. 홈페이지로 이동합니다.");
	            Homepage.exe(USER);
	            return;
	        }
	        
	        if(PASSWORD.equals(USER.getPASSWORD())) {
	        	HashMap<Integer, String> map = new HashMap<Integer, String>();
	        	map.put(1, USER.getEMAIL());
	        	if(CUD.exe(SQL, map)) {
	        		ConsoleClear.clear();
	        		System.out.println("회원탈퇴에 성공하였습니다. 메인 페이지로 이동합니다.");
	        		Main.exe();
	        		break;
	        	} else {
	        		System.out.println("회원탈퇴에 실패했습니다. 관리자에게 문의해주세요.");
	        	}
	        } else {
	        	System.out.println("비밀번호가 올바르지 않습니다. 다시 입력해주세요.");
	        }
	    
	        return;
	    }
	}
	
	public static void displayScreen() {
		System.out.println(""
				+ "███████╗ ██████╗ ██╗███╗   ██╗     ██████╗ ██╗   ██╗████████╗    \n"
				+ "██╔════╝██╔════╝ ██║████╗  ██║    ██╔═══██╗██║   ██║╚══██╔══╝    \n"
				+ "███████╗██║  ███╗██║██╔██╗ ██║    ██║   ██║██║   ██║   ██║       \n"
				+ "╚════██║██║   ██║██║██║╚██╗██║    ██║   ██║██║   ██║   ██║       \n"
				+ "███████║╚██████╔╝██║██║ ╚████║    ╚██████╔╝╚██████╔╝   ██║       \n"
				+ "╚══════╝ ╚═════╝ ╚═╝╚═╝  ╚═══╝     ╚═════╝  ╚═════╝    ╚═╝       \n"
				+ "                                                                 "
				+ "");
		
	}
}