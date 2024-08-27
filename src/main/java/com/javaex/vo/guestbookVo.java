package com.javaex.vo;

public class guestbookVo {
	
	//Fields
	private int personId;
	private String name;
	private String password;
	private String comments;
	private String time;
	
	//Constructor
	public guestbookVo(int personId, String name, String password, String comments) {
		this.personId = personId;
		this.name = name;
		this.password = password;
		this.comments = comments;
	}
	
	public guestbookVo(String name, String password, String comments) {
		
		this.name = name;
		this.password = password;
		this.comments = comments;

	}
	
	public guestbookVo(int personId, String name, String password, String comments, String time) {
		this.personId = personId;
		this.name = name;
		this.password = password;
		this.comments = comments;
		this.time = time;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getPersonId() {
		return personId;
	}

	public void setPersonId(int personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "guestbookVo [personId=" + personId + ", name=" + name + ", password=" + password + ", comments="
				+ comments + ", time=" + time + "]";
	}


	
	
	
	
	
	
	
}
