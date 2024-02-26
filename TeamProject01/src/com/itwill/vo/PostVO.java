package com.itwill.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class PostVO implements Serializable {
	private static final long serialVersionUID = 1L; // 직렬화 버전 관리용
	private int num;
	private String title;
	private String description;
	private Timestamp createdAt;
	private String eMail;
	private int itemnum;
	
	public PostVO() {
		this.num = 0;
		this.title = null;
		this.description = null;
		this.createdAt = null;
		this.eMail = null;
		this.itemnum = 0;
	}
	
	public PostVO(int Num, int ItemNum, String Title, String Description, String EMail) {
		this.num = Num;
		this.itemnum = ItemNum;
		this.title = Title;
		this.description = Description;
		this.eMail = EMail;
	}
	
	public PostVO(int Num, int ItemNum, String Title, String Description, String EMail, Timestamp CreatedAt) {
		this.num = Num;
		this.itemnum = ItemNum;
		this.title = Title;
		this.description = Description;
		this.eMail = EMail;
		this.createdAt = CreatedAt;
	}
	
	public PostVO(int ItemNum, String Title, String Description, String EMail) {
		this.itemnum = ItemNum;
		this.title = Title;
		this.description = Description;
		this.eMail = EMail;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getEMail() {
		return eMail;
	}

	public void setAuthor(String eMail) {
		this.eMail = eMail;
	}

	
	public int getItemnum() {
		return itemnum;
	}

	public void setItemnum(int itemnum) {
		this.itemnum = itemnum;
	}

	@Override
	public String toString() {
		return "PostVO [title=" + title + ", description=" + description + ", createdAt=" + createdAt
				+ ", eMail=" + eMail + ", itemnum=" + itemnum + "]";
	}

}
