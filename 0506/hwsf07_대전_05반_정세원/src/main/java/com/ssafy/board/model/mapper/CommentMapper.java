package com.ssafy.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.board.model.dto.CommentDto;

@Mapper //이것도 자동 스캔당함
public interface CommentMapper {
	public List<CommentDto> cmtList(int bnum);
	public int insert(CommentDto dto);
}
