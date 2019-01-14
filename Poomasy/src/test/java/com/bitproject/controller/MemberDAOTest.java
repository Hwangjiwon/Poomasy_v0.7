package com.bitproject.controller;

import javax.inject.Inject;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; //직접입력

import com.bitproject.domain.MemberVO;
import com.bitproject.persistence.MemberDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations= {"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class MemberDAOTest {
	@Inject
	private MemberDAO dao;

	@Test
	public void testInsertMember()throws Exception{
		MemberVO user = new MemberVO();
		user.setEmail("user04@naver.com");
		user.setPassword("user04");
		user.setUsername("USER04");
		user.setNickname("tester");
		user.setMobile("01011112222");
		dao.insertMember(user);
	}
}
