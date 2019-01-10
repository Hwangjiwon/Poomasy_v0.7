package com.bitproject.persistence;

import com.bitproject.domain.MemberVO;

public interface MemberDAO {
	public String getTime();
	public void insertMember(MemberVO user);
	public MemberVO selectMember(String userid)throws Exception;
	public MemberVO readWithPW(String userid, String userpw)throws Exception;
}
