package com.itwill.user.scanner;

import java.util.Scanner;

import com.itwill.VC.VC;

public class UserInputScanner {
    private VC vc = new VC();
    private Scanner scan;

    public UserInputScanner() {
        this.scan = new Scanner(System.in);
    }

    public String scanEmail() {
        System.out.println("이메일을 입력해 주세요.");
        String email = scan.nextLine();
        while(vc.CheckEmpty(email)) {
            System.out.println("이메일을 입력해 주세요.");
            email = scan.nextLine();
        }
        System.out.println();
        return email;
    }
    
    public String scanPassword() {
		System.out.println("비밀번호를 입력해 주세요.");
		String password = scan.nextLine();
		
		while(vc.CheckEmpty(password)) {
			System.out.println("비밀번호를 입력해 주세요.");
			password = scan.nextLine();
		}
		System.out.println();
		return password;
    }
    
    public String scanFirstName() {
		System.out.println("성(FirstName)을 입력해 주세요.");
		String firstName = scan.nextLine();
		
		while(vc.CheckNumber(firstName) | vc.CheckEmpty(firstName)) {
			System.out.println("성(FirstName)을 입력해 주세요.");
			firstName = scan.nextLine();
		}
		
		System.out.println();
		return firstName;
    }
    
    public String scanLastName() {
		System.out.println("이름을 입력해 주세요.");
		String lastName = scan.nextLine();
		
		while(vc.CheckNumber(lastName)) {
			System.out.println("이름을 입력해 주세요.");
			lastName = scan.nextLine();
		}
		
		System.out.println();
    	return lastName;
    }
    
    public String scanGender() {
	    System.out.println("성별을 입력해 주세요.");
	    System.out.println("1. 남자 / 2. 여자");
	    int GenderValue = scan.nextInt();
	    scan.nextLine();

	    while (GenderValue != 1 && GenderValue != 2) {
	    	System.out.println();
	        System.out.println("잘못된 정보를 입력하였습니다. 다시 입력해주새요.");
	        System.out.println("1. 남자 / 2. 여자");
	        GenderValue = scan.nextInt();
	        scan.nextLine();
	    }
	    
		if (GenderValue == 1) {
			System.out.println();
			return "Male";
		}
		else if (GenderValue == 2) {
			System.out.println();
			return "Female";
		}
		
		System.out.println("코드에 문제가 생겼습니다 scanGender메소드를 확인해 주세요.");
		return null;
	}
    
    public String scanAddress() {
		System.out.println("주소를 입력해 주세요.");
		String address = scan.nextLine();
		
		while (vc.CheckEmpty(address)) {
			System.out.println("주소를 입력해 주세요.");
			address = scan.nextLine();
		}
		
		System.out.println();
		return address;
	}
    
    
}
