package com.itwill.page;

import com.itwill.utils.UserInputScanner;
import com.itwill.crud.Userr_Select;

public class Login {
	private String EMAIL;
	private String PASSWORD;
	
	private UserInputScanner UIS = new UserInputScanner();
	
	public void login() {
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
		
		EMAIL = UIS.scanEmail();
        PASSWORD = UIS.scanPassword();
        
        Userr_Select US = new Userr_Select();
        US.SelectOne(EMAIL, PASSWORD);
	}
	
	private void ResetValue() {
		EMAIL = null;
		PASSWORD = null;
	}
	
}
