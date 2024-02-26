package com.itwill.utils;

public class ValidationCheck {
	// 입력값이 빈 값인지 확인합니다.
	public boolean CheckEmpty(String value) {
		boolean check = value.isEmpty();
		if (check) {
			System.out.println();
			System.out.println("빈 값 입니다. 다시 입력해주세요.");
		}
		return check;
	}
	
	public boolean CheckAtSign(String value) {
		boolean check = !value.contains("@");
		if (check) {
			System.out.println();
			System.out.println("이메일 형식이 아닙니다.");
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
	
	// 0 이상인지 체크
	public boolean CheckMoreThanZero(String value) {
		if (isNumber(value) == false) return false;
		if (Integer.parseInt(value) < 0) return false;
		return true;
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
	
	// 입력값이 숫자타입으로 변환될 수 있는지 확인합니다.
	public boolean isNumber(String value) {
		boolean check = true;
		try {
			Integer.parseInt(value);
			check = false;
		} catch (NumberFormatException e) {
			System.out.println("유효한 숫자가 아닙니다. 다시 입력해주세요.");
			check = true;
		}
		return check;
	}
	
	public boolean checkIsNumber(String value) {
		boolean check = false;
		try {
			Integer.parseInt(value);
			check = true;
		} catch (NumberFormatException e) {
			return false;
		}
		System.out.println("숫자타입의 데이터를 넣을 수 없습니다.");
		return check;
	}
}
