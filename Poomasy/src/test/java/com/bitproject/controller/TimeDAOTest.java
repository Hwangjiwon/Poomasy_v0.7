package com.bitproject.controller;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner; //수동으로 추가

import com.bitproject.persistence.TimeDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class TimeDAOTest {
    @Inject
    private TimeDAO dao;
    
    @Test
    public void testTime() throws Exception{
        System.out.println(dao.getTime());
    }
}

