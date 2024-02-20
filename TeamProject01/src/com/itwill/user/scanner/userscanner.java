package com.itwill.user.scanner;

import java.util.Scanner;

import com.itwill.user.vo.UserVO;

public class userscanner {
	private String EMAIL;
	private String PASSWORD;
	private String USERNAME;
	private String FIRSTNAME;
	private String LASTNAME;
	private String GENDER;
	private String ADDRESS;
	
	private int GenderValue;
	
	public UserVO register() {
		System.out.println("-------- 회원가입을 시작합니다. ---------");
		ResetValue();
		
		Scanner scan = new Scanner(System.in);
		
		ScanEmail(scan);
		ScanPassword(scan);
		ScanUsername(scan);
		ScanFirstName(scan);
		ScanLastName(scan);
		ScanGenderValue(scan);
		JudgeGender(GenderValue);
		ScanAddress(scan);
		
		UserVO newUser = new UserVO(EMAIL, PASSWORD, USERNAME, FIRSTNAME, LASTNAME, GENDER, ADDRESS);
		
		return newUser;
	}	
	private void ScanEmail(Scanner scan) {
		System.out.println("이메일을 입력해 주세요.");
		EMAIL = scan.nextLine();
	}
	
	private void ScanPassword(Scanner scan) {
		System.out.println("비밀번호를 입력해 주세요.");
		PASSWORD = scan.nextLine();
	}
	
	private void ScanUsername(Scanner scan) {
		System.out.println("닉네임을 입력해 주세요.");
		USERNAME = scan.nextLine();
		
		System.out.println();
	}
	
	private void ScanFirstName(Scanner scan) {
		System.out.println("성을 입력해 주세요.");
		FIRSTNAME = scan.nextLine();
		
		System.out.println();
	}
	
	private void ScanLastName(Scanner scan) {
		System.out.println("이름을 입력해 주세요.");
		LASTNAME = scan.nextLine();
		
		System.out.println();
	}
	
	private void ScanGenderValue(Scanner scan) {
		System.out.println("성별을 입력해 주세요.");
		System.out.println("1. 남자 / 2. 여자");
		GenderValue = scan.nextInt();
		
		System.out.println();
		while (GenderValue != (1 | 2)) {
			System.out.println("잘못된 정보를 입력하였습니다. 다시 입력해주새요.");
			ScanGenderValue(scan);
		}
		
	}

	private void ScanAddress(Scanner scan) {
		System.out.println("주소를 입력해 주세요.");
		ADDRESS = scan.nextLine();
		
		System.out.println();
	}
	
	private void JudgeGender(int GenderValue) {
		if (GenderValue == 1) {
			GENDER = "Male";
		}
		else if (GenderValue == 2) {
			GENDER = "Female";
		}
	}
	
	private void ResetValue() {
		EMAIL = null;
		PASSWORD = null;
		USERNAME = null;
		FIRSTNAME = null;
		LASTNAME = null;
		GENDER = null;
		ADDRESS = null;
		
		GenderValue = 0;
	}
}
