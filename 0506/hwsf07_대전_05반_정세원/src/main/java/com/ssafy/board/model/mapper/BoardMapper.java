package com.ssafy.board.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.board.model.dto.BoardDto;

@Mapper //이것도 자동 스캔당함
public interface BoardMapper {
	public int insert(BoardDto dto);
	public BoardDto selectOne(int bnum);
	public List<BoardDto> selectList(@Param("startRow")int startRow, @Param("count")int count);
	public int selectCount();
	public int delete(int bnum);
	public int update(BoardDto boardDto);
	public List<BoardDto> makeSearchPage(@Param("select")String select, @Param("search")String search);
}
