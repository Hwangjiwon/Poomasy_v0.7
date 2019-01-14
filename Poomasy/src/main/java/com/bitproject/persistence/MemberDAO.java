package com.bitproject.persistence;

import com.bitproject.domain.MemberVO;

public interface MemberDAO {
	public String getTime();
	public void insertMember(MemberVO user); //회원가입
	public MemberVO selectMember(String email)throws Exception;
	public MemberVO readWithPW(String email, String password)throws Exception;
	
}
