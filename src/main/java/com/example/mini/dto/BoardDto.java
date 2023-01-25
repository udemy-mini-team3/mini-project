package com.example.mini.dto;

import org.springframework.stereotype.Component;

@Component
public class BoardDto {
	
	private int seq;
	private int writer;
	private String title;
	private String content;
	private String insertDate;
	private String updateDate;
	private int viewcount;
	
	public BoardDto() {}

	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getWriter() {
		return writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(String insertDate) {
		this.insertDate = insertDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public int getViewcount() {
		return viewcount;
	}

	public void setViewcount(int viewcount) {
		this.viewcount = viewcount;
	}

	@Override
	public String toString() {
		return "BoardDto [seq=" + seq + ", writer=" + writer + ", title=" + title + ", content=" + content + ", insertDate="
				+ insertDate + ", updateDate=" + updateDate + ", viewcount=" + viewcount + "]";
	}

}
