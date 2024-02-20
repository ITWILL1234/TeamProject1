package com.itwill.user.scanner;

import com.itwill.user.vo.UserVO;

public class Test {

	public static void main(String[] args) {
		UserVO user1 = new userscanner().register();
		
		System.out.println(user1.toString());
	}

}
