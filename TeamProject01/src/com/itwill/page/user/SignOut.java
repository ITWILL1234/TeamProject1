package com.itwill.page.user;

import java.util.HashMap;

import com.itwill.page.utils.ConsoleClear;
import com.itwill.socket.client.ClientSignOut;
import com.itwill.utils.UserInputScanner;
import com.itwill.vo.UserVO;

public class SignOut {
	private static String PASSWORD;
	private static UserVO User;
	
	public static void exe(UserVO user) {
		User = user;
		displayScreen();
		if (userInput()) {
			processDeleteUser();
		};
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
	
	public static boolean userInput() {
		while(true) {
	        System.out.println("회원 탈퇴를 위하여 비밀번호를 입력해 주세요. (취소하려면 'q'를 입력하세요)");

	        PASSWORD = UserInputScanner.scanPassword();

	        // 사용자가 'q'를 입력했을 경우의 처리
	        if ("q".equalsIgnoreCase(PASSWORD)) {
	            System.out.println("취소되었습니다. 홈페이지로 이동합니다.");
	            Homepage.exe(User);
	            return false;
	        }
	        
	        if(PASSWORD.equals(User.getPASSWORD())) {
	        	// 추후 소켓 오라클 연동.
	        	return true;
	        } else {
	        	System.out.println("비밀번호가 올바르지 않습니다. 다시 입력해주세요.");
	        }
	        return false;
	    }
	}
	
	public static void processDeleteUser() {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
    	map.put(1, User.getEMAIL());
    	ClientSignOut clientSignOut = new ClientSignOut();
    	clientSignOut.start(map);
    	if(clientSignOut.getResult()) {
    		ConsoleClear.clear();
    		System.out.println("회원탈퇴에 성공하였습니다. 메인 페이지로 이동합니다.");
    		Main.exe();
    	} else {
    		System.out.println("회원탈퇴에 실패했습니다. 관리자에게 문의해주세요.");
    		exe(User);
    	}
	}
	
	
}