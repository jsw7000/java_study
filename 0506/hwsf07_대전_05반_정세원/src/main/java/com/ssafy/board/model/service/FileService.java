package com.ssafy.board.model.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dto.FileDto;
import com.ssafy.board.model.mapper.FileMapper;

@Service
public class FileService {

	@Autowired
	private SqlSession fdao;
	
	public int saveFile(FileDto dto) {
		return fdao.getMapper(FileMapper.class).insertFile(dto);
	}

	public FileDto searchFile(int fno) {
		return fdao.getMapper(FileMapper.class).selectOne(fno);
	}

	public List<FileDto> searchAll() {
		return fdao.getMapper(FileMapper.class).selectAll();
	}

}
