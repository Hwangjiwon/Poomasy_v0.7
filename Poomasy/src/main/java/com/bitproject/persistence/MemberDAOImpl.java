package com.bitproject.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bitproject.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO{
	@Inject
	private SqlSession sqlSession;
	private static final String namespace="com.bitproject.mapper.MemberMapper";
	public String getTime() {
		return sqlSession.selectOne(namespace+"getTime");
	}
	@Override
	public void insertMember(MemberVO user) {
		sqlSession.insert(namespace+".insertMember",user);
	}
	@Override
	public MemberVO selectMember(String userid) throws Exception{
		return(MemberVO)
				sqlSession.selectOne(namespace+".selectMember", userid);
	}
	@Override
	public MemberVO readWithPW(String userid, String userpw) throws Exception{

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);

		return sqlSession.selectOne(namespace+".readWithPW", paramMap);
	}
}