package com.itwill.vo;

import java.sql.Timestamp;

public class PostVO {
	private String title;
	private String description;
	private Timestamp createdAt;
	private Timestamp modifiedAt;
	private String eMail;
	
	public PostVO() {
		this.title = null;
		this.description = null;
		this.createdAt = null;
		this.modifiedAt = null;
		this.eMail = null;
	}
	
	public PostVO(String title, String description, Timestamp createdAt,
			Timestamp modifiedAt, String eMail) {
		this.title = title;
		this.description = description;
		this.createdAt = createdAt;
		this.modifiedAt = modifiedAt;
		this.eMail = eMail;
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

	public Timestamp getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(Timestamp modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public String getEMail() {
		return eMail;
	}

	public void setAuthor(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "PostVO [title=" + title + ", description=" + description + ", createdAt=" + createdAt + ", modifiedAt="
				+ modifiedAt + ", author=" + eMail + "]";
	}
	
	
}
