package com.itwill.utils;

import java.util.Scanner;

public class UserInputScanner {
    private ValidationCheck vc = new ValidationCheck();
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
	    
	    while(true) {
	    	try {
	    		String input = scan.nextLine();
	    		int genderValue = Integer.parseInt(input);
	    		
	    		if (genderValue == 1) {
	    			return "Male";
	    		} else if(genderValue ==2) {
	    			return "Female";
	    		} else {
	    			 System.out.println("\n1 또는 2를 입력해주세요. 다시 입력해주세요."); // 잘못된 숫자 입력 처리
	    		}
	    	} catch (NumberFormatException e) {
	    		System.out.println("\n숫자로 입력해주세요."); // 숫자가 아닌 입력 처리
	    	}
	    }
	}
    
    public String scanAddress() {
    	System.out.println();
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
