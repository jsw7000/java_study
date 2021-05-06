package com.ssafy.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.dto.FileDto;

@Mapper
public interface FileMapper {
	public int insertFile(FileDto dto); // 파일 저장
	public List<FileDto> selectAll(); // 파일목록
	public FileDto selectOne(int fno); // 파일 다운로드
}
