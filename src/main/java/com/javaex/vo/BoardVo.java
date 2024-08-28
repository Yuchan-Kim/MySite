package com.javaex.vo;

public class BoardVo {
	private int boardId;
	private String title;
	private String contents;
	private int views;
	private String writeTime;
	private int personId;
	private String name;
	
	

	public BoardVo(int boardId, String title, String contents, int views, String writeTime, int personId, String name) {
		this.boardId = boardId;
		this.title = title;
		this.contents = contents;
		this.views = views;
		this.writeTime = writeTime;
		this.personId = personId;
		this.name=name;
	}
	
	public BoardVo(int boardId, String title, String contents, int views, String writeTime, int personId) {
		this.boardId = boardId;
		this.title = title;
		this.contents = contents;
		this.views = views;
		this.writeTime = writeTime;
		this.personId = personId;
	}
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getPersonId() {
		return personId;
	}



	public void setPersonId(int personId) {
		this.personId = personId;
	}



	public int getBoardId() {
		return boardId;
	}

	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public String getWriteTime() {
		return writeTime;
	}

	public void setWriteTime(String writeTime) {
		this.writeTime = writeTime;
	}

	@Override
	public String toString() {
		return "BoardVo [boardId=" + boardId + ", title=" + title + ", contents=" + contents + ", views=" + views
				+ ", writeTime=" + writeTime + "]";
	}
	
	
	
	
}
