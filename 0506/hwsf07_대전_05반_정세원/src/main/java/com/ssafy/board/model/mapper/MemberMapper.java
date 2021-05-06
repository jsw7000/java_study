package com.ssafy.board.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.board.model.dto.MemberDto;

@Mapper
public interface MemberMapper {
	public MemberDto login(@Param("userid") String userid,@Param("userpwd") String userpwd);
	
}
