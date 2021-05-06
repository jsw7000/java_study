package com.ssafy.board.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.dto.CommentDto;
import com.ssafy.board.model.mapper.BoardMapper;
import com.ssafy.board.model.mapper.CommentMapper;


@Service
public class BoardService {
	@Autowired
	private SqlSession bdao;
	private static final int COUNT_PER_PAGE=10;
////////////////////////////////////////////////////////////////////	
	public Map<String, Object> makePage(int page){
		// 총 게시글 갯수 디비에서 조회함.
		int totalCount = bdao.getMapper(BoardMapper.class).selectCount();
		
		// 총 페이지수 계산
		int totalPage = totalCount/COUNT_PER_PAGE;
		if(totalCount%COUNT_PER_PAGE>0)
			totalPage++;
		
		// 화면 하단의 시작 페이지
		int startPage = (page-1)/10*10+1;
				
		int endPage = startPage+9;
		if(endPage>totalPage)
			endPage = totalPage;
		
		// 현재 페이지 게시글 조회
		int startRow = (page-1)*COUNT_PER_PAGE; // limit 의 시작행 번호 계산.
		List<BoardDto> bList = bdao.getMapper(BoardMapper.class).selectList(startRow, COUNT_PER_PAGE);
		
		Map<String, Object> pageInfo = new HashMap<>();
		
		pageInfo.put("startPage", startPage);
		pageInfo.put("endPage", endPage);
		pageInfo.put("totalPage", totalPage);
		pageInfo.put("curPage", page);
		pageInfo.put("bList", bList);
	
		return pageInfo;
	}

	public boolean write(BoardDto boardDto) {
		if(bdao.getMapper(BoardMapper.class).insert(boardDto)>0)
			return true;
		return false;
	}

	public BoardDto read(int bnum) {
		return bdao.getMapper(BoardMapper.class).selectOne(bnum);
	}
	public boolean delete(int bnum) {
		if(bdao.getMapper(BoardMapper.class).delete(bnum)>0)
			return true;
		return false;
	}
	
	public boolean update(BoardDto boardDto) {
		if(bdao.getMapper(BoardMapper.class).update(boardDto)>0)
			return true;
		return false;
	}
	
	public List<BoardDto> makeSearchPage(String select, String search) {
//		System.out.println(select+": "+search);
		List<BoardDto> bList = bdao.getMapper(BoardMapper.class).makeSearchPage(select,search);
		return bList;
	}
	
///////////////////////////////////////////////////////////////////
	public List<CommentDto> getCmtList(int bnum){
		return bdao.getMapper(CommentMapper.class).cmtList(bnum);
	}

	public boolean writeComment(CommentDto cmtDto) {
		if(bdao.getMapper(CommentMapper.class).insert(cmtDto)>0)
			return true;
		return false;
	}



}
