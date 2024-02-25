package com.itwill.vo;

import java.io.Serializable;

public class ItemVO implements Serializable {
    private static final long serialVersionUID = 1L; // 직렬화 버전 관리용
	private int Num;
	private	String Name;
	private int price;
	private String Image;
	
	public ItemVO(int Num, String Name, int price) {
		this.Num = Num;
		this.Name = Name;
		this.price = price;
		this.Image = null;
	}
	
	public ItemVO(int Num, String Name, int price, String Image) {
		this.Num = Num;
		this.Name = Name;
		this.price = price;
		this.Image = Image;
	}
	
	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public ItemVO() {
		this.Num = 0;
		this.Name = null;
		this.price = 0;
	}
	

	public int getNum() {
		return Num;
	}

	public void setNum(int Num) {
		this.Num = Num;
	}

	public String Name() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "제품번호 : " + Num + ", 제품 이름=" + Name + ", 제품 가격 : " + price ; 
	}
	
	
}
