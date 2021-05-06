package com.ssafy.board.model.dto;

import java.util.Date;

public class BoardDto {
	private int bnum;
	private String btitle;
	private String bcontent;
	private String bwriter;
	private Date bregdate; // mysql에는 timestamp로 해놨음. 자바는 java.util.Date

	////////////////////////////////////////////////////////////////////////////
	public BoardDto(int bnum, String btitle, String bcontent, String bwriter, Date bregdate) {
		this.bnum = bnum;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bwriter = bwriter;
		this.bregdate = bregdate;
	}

	public BoardDto() {
	}
/////////////////////////////////////////////////////////////////////////////
	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public Date getBregdate() {
		return bregdate;
	}

	public void setBregdate(Date bregdate) {
		this.bregdate = bregdate;
	}
	

	@Override
	public String toString() {
		return "BoardDto [bnum=" + bnum + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bwriter=" + bwriter
				+ ", bregdate=" + bregdate + "]";
	}
}
