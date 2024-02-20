package com.itwill.user.scanner;

import java.util.Scanner;

public class userscanner {
	private String EMAIL;
	private String PASSWORD;
	private String USERNAME;
	private String FIRSTNAME;
	private String LASTNAME;
	private int GENDER;
	private String ADDRESS;
	
	public void register() {
		System.out.println("-------- 회원가입을 시작합니다. ---------");
		ResetValue();
		
		Scanner scan = new Scanner(System.in);
		
		ScanEmail(scan);
		ScanPassword(scan);
		ScanUsername(scan);
		ScanFirstName(scan);
		ScanLastName(scan);
		ScanGender(scan);
		ScanAddress(scan);
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
	
	private void ScanGender(Scanner scan) {
		System.out.println("성별을 입력해 주세요.");
		System.out.println("1. 남자 / 2. 여자");
		GENDER = scan.nextInt();
		
		System.out.println();
		while (GENDER != (1 | 2)) {
			System.out.println("잘못된 정보를 입력하였습니다. 다시 입력해주새요.");
			ScanGender(scan);
		}
	}

	private void ScanAddress(Scanner scan) {
		System.out.println("주소를 입력해 주세요.");
		ADDRESS = scan.nextLine();
		
		System.out.println();
	}
	
	private void ResetValue() {
		EMAIL = null;
		PASSWORD = null;
		USERNAME = null;
		FIRSTNAME = null;
		LASTNAME = null;
		GENDER = 0;
		ADDRESS = null;
	}
}
