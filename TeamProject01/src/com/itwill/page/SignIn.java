package com.itwill.page;

import com.itwill.utils.UserInputScanner;
import com.itwill.vo.UserVO;

public class SignIn {
	private String EMAIL;
	private String PASSWORD;
	private String FIRSTNAME;
	private String LASTNAME;
	private String GENDER;
	private String ADDRESS;
	
	public UserVO exe() {
		System.out.println(""
				+ "\n"
				+ "██████╗ ███████╗ ██████╗ ██╗███████╗████████╗██████╗  █████╗ ████████╗██╗ ██████╗ ███╗   ██╗\n"
				+ "██╔══██╗██╔════╝██╔════╝ ██║██╔════╝╚══██╔══╝██╔══██╗██╔══██╗╚══██╔══╝██║██╔═══██╗████╗  ██║\n"
				+ "██████╔╝█████╗  ██║  ███╗██║███████╗   ██║   ██████╔╝███████║   ██║   ██║██║   ██║██╔██╗ ██║\n"
				+ "██╔══██╗██╔══╝  ██║   ██║██║╚════██║   ██║   ██╔══██╗██╔══██║   ██║   ██║██║   ██║██║╚██╗██║\n"
				+ "██║  ██║███████╗╚██████╔╝██║███████║   ██║   ██║  ██║██║  ██║   ██║   ██║╚██████╔╝██║ ╚████║\n"
				+ "╚═╝  ╚═╝╚══════╝ ╚═════╝ ╚═╝╚══════╝   ╚═╝   ╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝\n"
				+ "                                                                                            \n"
				+ "");
		System.out.println(">> 회원가입을 시작합니다.");
		ResetValue();
		
		// 유저의 입력을 받는 코드입니다.
        EMAIL = UserInputScanner.scanEmail();
        PASSWORD = UserInputScanner.scanPassword();
        FIRSTNAME = UserInputScanner.scanFirstName();
        LASTNAME = UserInputScanner.scanLastName();
        GENDER = UserInputScanner.scanGender();
		ADDRESS = UserInputScanner.scanAddress();
		
		UserVO newUser = new UserVO(EMAIL, PASSWORD, FIRSTNAME, LASTNAME, GENDER, ADDRESS);
		
		return newUser;
	}	
	
	private void ResetValue() {
		EMAIL = null;
		PASSWORD = null;
		FIRSTNAME = null;
		LASTNAME = null;
		GENDER = null;
		ADDRESS = null;
	}
}
