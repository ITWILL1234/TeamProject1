package com.itwill.VC;

public class VC {
	// 입력값이 빈 값인지 확인합니다.
	public boolean CheckEmpty(String value) {
		boolean check = value.isEmpty();
		if (check) {
			System.out.println();
			System.out.println("빈 값 입니다. 다시 입력해주세요.");
		}
		return check;
	}
	
	// 입력값에 숫자가 포함되어 있는지 확인합니다.
	public boolean CheckNumber(String value) {
		boolean check = value.matches(".*\\d+.*");
		if(check) {			
			System.out.println();
			System.out.println("숫자가 포함되어 있습니다. 다시 입력해주세요.");
		}
		return check;
	}
	
	// 입력값에 한글이 포함되어 있는지 확인합니다.
	public boolean CheckHan(String value) {
		boolean check = value.matches(".*[ㄱ-ㅎㅏ-ㅣ가-힣]+.*");
		if (check) {
			System.out.println();
			System.out.println("한글이 포함되어 있습니다. 다시 입력해주세요.");
		}
		return check;
	}
	
	// 입력값에 빈칸이 포함되어 있는지 확인합니다.
	public boolean CheckBlank(String value) {
		boolean check = value.contains(" ");
		if (check) {
			System.out.println();
			System.out.println("빈칸이 포함되어 있습니다.");
		}
		return check;
	}
}
