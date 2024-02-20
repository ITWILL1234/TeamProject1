package com.itwill.main;

import java.util.Scanner;
import com.itwill.crud.Userr_Insert;
import com.itwill.page.ConsoleClear;


public class main {

	public static void main(String[] args) {
		ConsoleClear erase = new ConsoleClear();
		
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
			Userr_Insert regist = new Userr_Insert();
			erase.clear();
			regist.start();
			
		} else if (inputRL == 2) {
			erase.clear();
			System.out.println("로그인 창으로 넘어갑니다.");
		}

	}

}

