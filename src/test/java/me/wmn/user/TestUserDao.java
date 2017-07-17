package me.wmn.user;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import me.wmn.util.IDGenerator;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/fastpublish-servlet.xml"})
public class TestUserDao {
	@Autowired
	private SqlSession ss;
	
	private UserDao userDao;
	
	@Before
	public void setUp(){
//		ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/fastpublish-servlet.xml");
//		ss = ctx.getBean(SqlSession.class);
		
		userDao = new UserDao(ss);
		
		User user = new User();
		user.setUserId(IDGenerator.getNextId());
		user.setUsername("Fred Fu");
		user.setPassword("fred");
		user.setEmail("fred.fu@lexisnexis.com");
		user.setIntro("Software engineer");
		userDao.addUser(user);
	}
	
	@Test
	public void testGetNotExistUser(){
		User u = userDao.getUser("Not Exist");
		Assert.assertNull(u);
	}
	
	@Test 
	public void testGetExistUser(){
		User u = userDao.getUser("Fred Fu");
		Assert.assertNotNull(u);
		Assert.assertEquals("Fred Fu", u.getUsername());
	}
	
	@After
	public void tearDown(){
		userDao.deleteAll();
	}

}
