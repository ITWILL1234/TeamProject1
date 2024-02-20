package com.itwill.page;

import java.util.Scanner;
import com.itwill.VC.*;

public class Login {
	private String EMAIL;
	private String PASSWORD;
	private VC vc = new VC();
	Scanner scan = new Scanner(System.in);
	
	public void start() {
		
		}
		
	private void ScanEmail(Scanner scan) {
		System.out.println("이메일을 입력해 주세요.");
		EMAIL = scan.nextLine();
		
		while(vc.CheckEmpty(EMAIL)) {
			System.out.println("이메일을 입력해 주세요.");
			EMAIL = scan.nextLine();
		}
		
	}
	
	private void ScanPassword(Scanner scan) {
		System.out.println("비밀번호를 입력해 주세요.");
		PASSWORD = scan.nextLine();
		
		while(vc.CheckEmpty(PASSWORD)) {
			System.out.println("비밀번호를 입력해 주세요.");
			PASSWORD = scan.nextLine();
		}
	}
	
}
