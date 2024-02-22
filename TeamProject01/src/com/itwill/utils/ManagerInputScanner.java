package com.itwill.utils;
import java.util.Scanner;

public class ManagerInputScanner {
		private static ValidationCheck vc = new ValidationCheck();
		private static Scanner scan = new Scanner(System.in);

	
		public static String scanEmail() {
	        System.out.println("이메일을 입력해 주세요.");
	        String email = scan.nextLine();
	        while(vc.CheckEmpty(email)) {
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

//		public static String scanManager() {
//			// TODO Auto-generated method stub
//			return null;
//		}
}
