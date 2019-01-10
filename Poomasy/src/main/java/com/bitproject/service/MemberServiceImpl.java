package com.bitproject.service;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.bitproject.controller.HomeController;
import com.bitproject.domain.MemberVO;
import com.bitproject.persistence.MemberDAO;

@Repository
public class MemberServiceImpl implements MemberService {
	@Inject
	private MemberDAO dao;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Override
	public void regist(MemberVO user) throws Exception {
		// TODO Auto-generated method stub
		logger.info("service " + user.toString());

		dao.insertMember(user);
	}

}
