package com.ssafy.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.board.model.dto.CommentDto;
import com.ssafy.board.model.service.BoardService;


@RestController
@CrossOrigin("*")
public class CommentController {
	@Autowired
	private BoardService bservice;

	@GetMapping(value ="/ajax",produces = "application/json; charset=utf8") //댓글 목록 좀 주세염 이라는 요청(댓글에 있는 한글 처리땜시 produces 추가함)
	public List<CommentDto> ajax(int bnum){
		return bservice.getCmtList(bnum);
	}
	
	@PostMapping(value="/ajax") //댓글 쓸래염 이라는 요청
	public String ajax(@RequestBody CommentDto cmtDto) { //javascript에서 json 데이터를 보냈을 때 back은 꼭 @RequestBody로 받아야 함.
		if(bservice.writeComment(cmtDto))
			return "success"; //success.jsp 아니니까! html만드는거 아니니까! 그냥 이 데이터 바로 response
		else
			return "fail";
	}
}

