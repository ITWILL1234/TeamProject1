package com.itwill.page;

/*
 * 콘솔창을 깨끗히 만들어주는 코드입니다.
 * 자바에서는 해당 기능을 지원하지 않아... 수동으로 지우기위하여 Sysout을 여러번 해야 합니다.
 */

public class ConsoleClear {
	public void clear() {
		for(int i = 0; i < 100; i++) {
		    System.out.println();
		}
	}
}
