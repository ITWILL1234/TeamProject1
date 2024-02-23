package com.itwill.vo;

public class OrderVO {
	//이메일, 주소, 상품번호, 상품명, 주문수량, 결제금액
	private String eMail;
	private String address;
	private int itemNum;
	private String itemName;
	private int itemCount;
	private int tot;
	
	public OrderVO() {
		this.eMail = null;
		this.address = null;
		this.itemNum = 0;
		this.itemName = null;
		this.itemCount = 0;
		this.tot = 0;
	}

	public OrderVO(String eMail, String address, int itemNum, String itemName, int itemCount, int tot) {
		super();
		this.eMail = eMail;
		this.address = address;
		this.itemNum = itemNum;
		this.itemName = itemName;
		this.itemCount = itemCount;
		this.tot = tot;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getItemNum() {
		return itemNum;
	}

	public void setItemNum(int itemNum) {
		this.itemNum = itemNum;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemCount() {
		return itemCount;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	@Override
	public String toString() {
		return "OrderVO [eMail=" + eMail + ", address=" + address + ", itemNum=" + itemNum + ", itemName=" + itemName
				+ ", itemCount=" + itemCount + ", tot=" + tot + "]";
	}
	
	
}
