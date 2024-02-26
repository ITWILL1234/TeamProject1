package com.itwill.page.item;

import com.itwill.crud.Read;
import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class Post {
	private static UserVO User;
	private static int ItemNum;
	
	
	public static void exe(UserVO user, int item) {
		ItemNum = 0;
		User = user;
		ItemNum = item;
		
		postpage();
	
	}
	private static void postpage() {
		System.out.println("\n * 사용자들의 리뷰 *");
		System.out.println(Read.getPost(ItemNum));
	}
	
}
