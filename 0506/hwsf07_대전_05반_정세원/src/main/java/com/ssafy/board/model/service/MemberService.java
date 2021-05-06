package com.ssafy.board.model.service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.board.model.dto.MemberDto;
import com.ssafy.board.model.mapper.MemberMapper;

@Service
public class MemberService {
	
	@Autowired
	private SqlSession mdao;
	
	public MemberDto login(String userid,String userpwd) throws SQLException,Exception {
		return mdao.getMapper(MemberMapper.class).login(userid, userpwd);
	}

	
}
