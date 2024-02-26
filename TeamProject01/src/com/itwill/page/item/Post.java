package com.itwill.page.item;

import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class Post {
	private static UserVO User;
	private static ItemVO Item;
	public void exe(UserVO user, ItemVO item) {
		User = user;
		Item = item;
		
		postpage();
	}
	private void postpage() {
		// TODO Auto-generated method stub
		
	}
	
}
