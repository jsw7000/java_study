package com.ssafy.board.model.dto;

import org.springframework.web.multipart.MultipartFile;

public class FileDto {
	private int fno;
	private String filename; // 클라이언트가 원하는 파일이름
	private String origin; // 서버쪽에 실제 저장된 경로및이름
	private MultipartFile uploadFile; // 실제 업로드되는 파일객체
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public MultipartFile getUploadFile() {
		return uploadFile;
	}
	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}
	

	
	
}
