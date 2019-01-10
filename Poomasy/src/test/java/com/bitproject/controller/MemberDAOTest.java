package com.bitproject.controller;

import javax.inject.Inject;
import org.junit.runner.RunWith;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; //수동으로 추가

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
		MemberVO vo = new MemberVO();
		vo.setUserid("user00");
		vo.setUserpw("user00");
		vo.setUsername("USER00");
		dao.insertMember(vo);
	}
}
