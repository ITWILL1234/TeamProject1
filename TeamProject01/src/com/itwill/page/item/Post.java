package com.itwill.page.item;

import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class Post {
	private static UserVO User;
	private static int ItemNum;
	
	
	public static void exe(UserVO user, int item) {
	User = user;
	ItemNum = item;
	
	postpage();
	
	}
	private static void postpage() {
		System.out.println("/n * 사용자들의 리뷰 *");
		
		
	}
	
}
