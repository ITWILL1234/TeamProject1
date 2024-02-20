package com.itwill.main;

import java.util.Scanner;

public class mainpage {

	public static void main(String[] args) {
		int inputRL = 0;
		Scanner scan = new Scanner(System.in);
		System.out.println(""
				+ "\n"
				+ "███████╗    ███╗   ███╗ █████╗ ██╗     ██╗     \n"
				+ "██╔════╝    ████╗ ████║██╔══██╗██║     ██║     \n"
				+ "█████╗█████╗██╔████╔██║███████║██║     ██║     \n"
				+ "██╔══╝╚════╝██║╚██╔╝██║██╔══██║██║     ██║     \n"
				+ "███████╗    ██║ ╚═╝ ██║██║  ██║███████╗███████╗\n"
				+ "╚══════╝    ╚═╝     ╚═╝╚═╝  ╚═╝╚══════╝╚══════╝\n"
				+ "                                               \n"
				+ "");
		System.out.println();
		System.out.println("1. 회원가입 2. 로그인");
		inputRL = scan.nextInt();
		scan.nextLine();
		
		while (inputRL != 1 && inputRL != 2) {
			System.out.println();
			System.out.println("입력값이 올바르지 않습니다.");
			inputRL = scan.nextInt();
			scan.nextLine();
		}
		
		if (inputRL == 1) {
			System.out.println("회원가입 창으로 넘어갑니다.");
			
		} else if (inputRL == 2) {
			System.out.println("로그인 창으로 넘어갑니다.");
		}

	}

}
