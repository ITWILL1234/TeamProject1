package com.itwill.utils;

import java.util.Scanner;

public class UserInputScanner {
    private static ValidationCheck vc = new ValidationCheck();
    private static Scanner scan = new Scanner(System.in);


    public static String scanEmail() {
        System.out.println("이메일을 입력해 주세요.");
        String email = scan.nextLine();
        while(vc.CheckEmpty(email) || vc.CheckAtSign(email)) {
            System.out.println("이메일을 입력해 주세요.");
            email = scan.nextLine();
        }
        System.out.println();
        return email;
    }
    
    public static String scanPassword() {
		System.out.println("비밀번호를 입력해 주세요.");
		String password = scan.nextLine();
		
		while(vc.CheckEmpty(password)) {
			System.out.println("비밀번호를 입력해 주세요.");
			password = scan.nextLine();
		}
		System.out.println();
		return password;
    }
    
    public static String scanFirstName() {
		System.out.println("성(FirstName)을 입력해 주세요.");
		String firstName = scan.nextLine();
		
		while(vc.CheckNumber(firstName) || vc.CheckEmpty(firstName)) {
			System.out.println("성(FirstName)을 입력해 주세요.");
			firstName = scan.nextLine();
		}
		
		System.out.println();
		return firstName;
    }
    
    public static String scanLastName() {
		System.out.println("이름을 입력해 주세요.");
		String lastName = scan.nextLine();
		
		while(vc.CheckNumber(lastName) || vc.CheckEmpty(lastName)) {
			System.out.println("이름을 입력해 주세요.");
			lastName = scan.nextLine();
		}
		
		System.out.println();
    	return lastName;
    }
    
    public static String scanGender() {
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
	    			 System.out.println("\n1 또는 2를 입력해주세요."); // 잘못된 숫자 입력 처리
	    		}
	    	} catch (NumberFormatException e) {
	    		System.out.println("\n숫자로 입력해주세요."); // 숫자가 아닌 입력 처리
	    	}
	    }
	}
    
    public static String scanAddress() {
    	System.out.println();
		System.out.println("주소를 입력해 주세요.");
		String address = scan.nextLine();
		
		while (vc.CheckEmpty(address) || vc.checkIsNumber(address)) {
			System.out.println("주소를 입력해 주세요.");
			address = scan.nextLine();
		}
		
		System.out.println();
		return address;
	}
    
    public static int scanNumber() {
    	System.out.println();
    	System.out.println("숫자를 입력해주세요.");
    	System.out.print("수량 : ");
    	String number = scan.nextLine();
    	
    	while (vc.isNumber(number)) {
    		number = scan.nextLine();
    	}
    	
    	System.out.println();
    	return Integer.parseInt(number);
    }
    
    public static String scanProductName() {
    	System.out.println();
    	System.out.println("상품명을 입력해주세요.");
    	String productName = scan.nextLine();
    	
    	while(vc.checkIsNumber(productName) || vc.CheckEmpty(productName)) {
    		System.out.println("상품명을 입력해주세요.");
    		productName = scan.nextLine();
    	}
    	return productName;
    }
    
    public static int scanProductPrice() {
    	System.out.println();
    	System.out.println("상품 가격을 입력해주세요.");
    	String productPrice = scan.nextLine();
    	
    	while(vc.CheckMoreThanZero(productPrice)) {
    		System.out.println("0이상의 숫자를 입력해주세요.");
    		productPrice = scan.nextLine();
    	}
    	return Integer.parseInt(productPrice);
    }
    
    public static String scanProductImage() {
    	System.out.println();
    	System.out.println("상품의 이미지를 입력해주세요.");
    	String productImage = scan.nextLine();
    	
    	while(vc.CheckEmpty(productImage) || vc.checkIsNumber(productImage)) {
    		System.out.println("상품의 이미지를 입력해주세요.");
    	}
    	
    	return productImage;
    }
    
}
