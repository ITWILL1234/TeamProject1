package com.itwill.page.item;

import com.itwill.socket.client.ClientInsertReview;
import com.itwill.utils.UserInputScanner;
import com.itwill.vo.ItemVO;
import com.itwill.vo.PostVO;
import com.itwill.vo.UserVO;

public class Review {
	private static UserVO User;
	private static ItemVO Item;
	private static String Title;
	private static String Description;
	public static void exe(UserVO user, ItemVO item) {
		User = user;
		Item = item;
		displayScreen();
		Title = UserInputScanner.scanTitle();
		Description = UserInputScanner.scanDescription();
		ClientInsertReview clientInsertReview = new ClientInsertReview();
		clientInsertReview.start(new PostVO(Item.getNum(), Title, Description, user.getEMAIL()));
		ItemPage.exe(User, Item);
	}
	
	private static void displayScreen() {
		System.out.println(""
				+ "\n"
				+ "██████╗ ███████╗██╗   ██╗██╗███████╗██╗    ██╗\n"
				+ "██╔══██╗██╔════╝██║   ██║██║██╔════╝██║    ██║\n"
				+ "██████╔╝█████╗  ██║   ██║██║█████╗  ██║ █╗ ██║\n"
				+ "██╔══██╗██╔══╝  ╚██╗ ██╔╝██║██╔══╝  ██║███╗██║\n"
				+ "██║  ██║███████╗ ╚████╔╝ ██║███████╗╚███╔███╔╝\n"
				+ "╚═╝  ╚═╝╚══════╝  ╚═══╝  ╚═╝╚══════╝ ╚══╝╚══╝ \n"
				+ "                                              \n"
				+ "");
	}
	
}
