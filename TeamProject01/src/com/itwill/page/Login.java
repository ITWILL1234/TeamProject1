package com.itwill.page;

import com.itwill.utils.UserInputScanner;
import com.itwill.crud.Userr_Select;

public class Login {
	private String EMAIL;
	private String PASSWORD;
	
	private UserInputScanner UIS = new UserInputScanner();
	
	public void exe() {
		System.out.println(""
				+ "\n"
				+ "██╗      ██████╗  ██████╗ ██╗███╗   ██╗\n"
				+ "██║     ██╔═══██╗██╔════╝ ██║████╗  ██║\n"
				+ "██║     ██║   ██║██║  ███╗██║██╔██╗ ██║\n"
				+ "██║     ██║   ██║██║   ██║██║██║╚██╗██║\n"
				+ "███████╗╚██████╔╝╚██████╔╝██║██║ ╚████║\n"
				+ "╚══════╝ ╚═════╝  ╚═════╝ ╚═╝╚═╝  ╚═══╝\n"
				+ "                                       \n"
				+ "");
		System.out.println(">> 로그인을 시작합니다.");
		ResetValue();
		
		/* 이메일과 비밀번호를 입력받는 코드입니다. (Scanner 사용)
		 */ 
		EMAIL = UIS.scanEmail();
        PASSWORD = UIS.scanPassword();
        
        /* 오라클의 user테이블에서 WHERE EMAIL 조회를 하여,
         * 비밀번호가 맞는지 확인하는 코드입니다.
         */
        Userr_Select US = new Userr_Select();
        US.SelectOne(EMAIL, PASSWORD);
	}
	
	private void ResetValue() {
		EMAIL = null;
		PASSWORD = null;
	}
	
}
