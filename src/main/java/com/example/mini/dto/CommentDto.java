package com.example.mini.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.stereotype.Component;

@Component
public class CommentDto {

	private int seq;
	private int boardSeq;
	private int writer;
	private String content;
	private String insertDate;
	private String updateDate;
	
	public CommentDto() {}



	public int getSeq() {
		return seq;
	}

	public void setSeq(int seq) {
		this.seq = seq;
	}

	public int getBoardSeq() {
		return boardSeq;
	}

	public void setBoardSeq(int boardSeq) {
		this.boardSeq = boardSeq;
	}

	public int getWriter() {
		return writer;
	}

	public void setWriter(int writer) {
		this.writer = writer;
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

	@Override
	public String toString() {
		return "CommentDto [seq=" + seq + ", boardSeq=" + boardSeq + ", writer=" + writer + ", content=" + content
				+ ", insertDate=" + insertDate + ", updateDate=" + updateDate + "]";
	}
	
	
}
