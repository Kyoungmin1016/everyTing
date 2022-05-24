package org.tukorea.free;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.tukorea.free.persistence.MemberDAO;
import org.tukorea.free.MemberDAOTest;
import org.tukorea.free.domain.MemberVO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MemberDAOTest {
	
	@Autowired
	private MemberDAO dao;
	private static final Logger logger = LoggerFactory.getLogger(MemberDAOTest.class);

	@Test
	public void testReadByid() throws Exception{
		MemberVO vo;
		vo = dao.read("test");
		logger.info(vo.toString());
	}
	
	@Test
	public void testAdd() throws Exception{
		MemberVO vo = new MemberVO();
		vo.setId("test1");
		vo.setPasswd("passwd");
		vo.setMajor("tester");
		vo.setUsername("ев╫╨ем");
		vo.setAge(12);
		vo.setSex("woman");
		
		dao.add(vo);
		
	}
	
}
