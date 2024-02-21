package com.itwill.itemDEMO;

import java.util.ArrayList;

import com.itwill.vo.ItemVO;
import com.itwill.vo.UserVO;

public class SeedData {
	public static UserVO createUserVO() {
		UserVO user = new UserVO("aaa", "bbb", "ccc", "ddd", "male", "suwon");
		return user;
	}
	
	public static ArrayList<ItemVO> createItemVO() {
		ArrayList<ItemVO> list = new ArrayList<ItemVO>();
		list.add(new ItemVO(1, "apple", 1000, 3));
		list.add(new ItemVO(2, "banana", 2000, 1));
		list.add(new ItemVO(3, "orangeorangeorange", 2500, 1));
		list.add(new ItemVO(4, "pear", 5000, 2));
		list.add(new ItemVO(5, "mango", 4500, 3));
		return list;
	}

	
}
