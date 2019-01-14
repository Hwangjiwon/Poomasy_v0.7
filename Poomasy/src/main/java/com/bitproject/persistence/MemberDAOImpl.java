package com.bitproject.persistence;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bitproject.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {
	@Inject
	private SqlSession sqlSession;
	private static final String namespace = "com.bitproject.mapper.MemberMapper";

	public String getTime() {
		return sqlSession.selectOne(namespace + "getTime");
	}

	@Override
	public void insertMember(MemberVO user) { //회원가입
		sqlSession.insert(namespace + ".insertMember", user);
	}

	@Override
	public MemberVO selectMember(String email) throws Exception { //회원검색
		return (MemberVO) sqlSession.selectOne(namespace + ".selectMember", email);
	}

	@Override
	public MemberVO readWithPW(String email, String password) throws Exception { //회원email+pw 읽기

		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("email", email);
		paramMap.put("password", password);

		return sqlSession.selectOne(namespace + ".readWithPW", paramMap);
	}
	
}