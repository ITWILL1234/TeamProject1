package com.itwill.page;

import com.itwill.utils.UserInputScanner;
import com.itwill.vo.UserVO;
import com.itwill.crud.Userr_Delete;

public class SignOut {
	private String PASSWORD;
	
	private ConsoleClear erase = new ConsoleClear();
	private Main mainPage = new Main();
	private UserInputScanner UIS = new UserInputScanner();
	private Userr_Delete UD = new Userr_Delete();
	
	public void Out(UserVO user) {
		System.out.println(""
				+ "███████╗ ██████╗ ██╗███╗   ██╗     ██████╗ ██╗   ██╗████████╗    \n"
				+ "██╔════╝██╔════╝ ██║████╗  ██║    ██╔═══██╗██║   ██║╚══██╔══╝    \n"
				+ "███████╗██║  ███╗██║██╔██╗ ██║    ██║   ██║██║   ██║   ██║       \n"
				+ "╚════██║██║   ██║██║██║╚██╗██║    ██║   ██║██║   ██║   ██║       \n"
				+ "███████║╚██████╔╝██║██║ ╚████║    ╚██████╔╝╚██████╔╝   ██║       \n"
				+ "╚══════╝ ╚═════╝ ╚═╝╚═╝  ╚═══╝     ╚═════╝  ╚═════╝    ╚═╝       \n"
				+ "                                                                 "
				+ "");
		
	    int result;
	    do {
	        System.out.println("회원 탈퇴를 위하여 비밀번호를 입력해 주세요. (취소하려면 'q'를 입력하세요)");

	        PASSWORD = UIS.scanPassword();

	        // 사용자가 'esc'를 입력했을 경우의 처리
	        if ("q".equals(PASSWORD)) {
	            System.out.println("취소되었습니다. 다른 페이지로 이동합니다.");
	            // 다른 페이지로 이동하는 코드, 홈페이지 구현 필
	            return; // 이 메소드를 종료하고 빠져나갑니다.
	        }

	        result = UD.deleteUser(user, PASSWORD);
	        erase.clear();

	        if (result == 1) {
	            System.out.println("회원탈퇴가 되었습니다. 메인 페이지로 이동합니다!");
	            System.out.println();
	            // mainPage.main(null); 메인페이지 리디렉션 코드. 추후 수정 필요.
	            break; // 루프를 빠져나갑니다.
	        } else if (result == 400) {
	            System.out.println("비밀번호가 일치하지 않습니다! 다시 입력해 주세요.");
	        } else if (result == 404) {
	            System.out.println("회원 탈퇴 도중 에러가 발생하였습니다. 관리자에게 문의하세요.");
	        } else {
	            System.out.println("Result Value : " + result);
	            System.out.println("잘못된 경로입니다. 예외를 처리하세요.");
	        }
	    } while (result != 1);
	}
}