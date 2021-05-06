package com.ssafy.board.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssafy.board.model.dto.BoardDto;
import com.ssafy.board.model.dto.MemberDto;
import com.ssafy.board.model.service.BoardService;

@Controller
public class BoardController {
	

	@Autowired
	private BoardService bservice;
	
	@GetMapping("/list") // parameter가 url에 나타나는 구식 버전 
	public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") int page) {
		ModelAndView mav = new ModelAndView("board_list");
		mav.addObject("pageInfo", bservice.makePage(page));
		return mav;
	}
	
	@GetMapping("/read/{bnum}") // parameter 이름이 url에 나타나지 않고 값만 들어있는 신식 버전
	public ModelAndView read(@PathVariable("bnum") int bnum,HttpSession session,HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("board_read");
		BoardDto board = bservice.read(bnum);
		mav.addObject("boardDto", board);
		MemberDto loginUser = (MemberDto) session.getAttribute("loginUser");
		if(loginUser!=null&&loginUser.getUserid().equals(board.getBwriter())) {
			request.setAttribute("sameWriter", "sameWriter");
		}
		return mav;
	}
	
	@GetMapping("/write")
	public String write(HttpServletRequest request, HttpSession session) {
		return "board_write";
	}
	

	@PostMapping("/write")
	public String write(HttpSession session,BoardDto board) {
		MemberDto loginInfo = (MemberDto) session.getAttribute("loginUser");
		board.setBwriter(loginInfo.getUserid());
		if(bservice.write(board))
			return "write_success";
		else
			return "write_fail";
	}
	
	
	@GetMapping("/delete/{bnum}")
	public String delete(HttpServletRequest request,@PathVariable("bnum") int bnum) {
			if(bservice.delete(bnum)) {
				request.setAttribute("deleteMsg", "삭제되었습니다.");
			}
		return "redirect:/list"; //글 삭제 후 list로 redirect
	}
	
	@GetMapping("/update/{bnum}")
	public ModelAndView update(HttpServletRequest request,@PathVariable("bnum") int bnum) {
		ModelAndView mav = new ModelAndView("board_update");
		mav.addObject("boardDto", bservice.read(bnum));
		return mav;
	}
	
	
	@PostMapping("/update")
	public String update(BoardDto boardDto) {
		bservice.update(boardDto);
//		return "redirect:/read/"+boardDto.getBnum();
		return "redirect:/list";
	}
	
	@PostMapping("/search")
	public ModelAndView search(String select,String search) {
//		System.out.println(select+": "+search);
		ModelAndView mav = new ModelAndView("search_result");
		mav.addObject("searchList", bservice.makeSearchPage(select,search));

		
		return mav;
	}
}













