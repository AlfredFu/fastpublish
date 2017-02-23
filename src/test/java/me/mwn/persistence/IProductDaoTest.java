package me.mwn.persistence;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.wmn.domain.Product;
import me.wmn.persistence.jdbcimpl.JdbcProductDao;


public class IProductDaoTest {
	static JdbcProductDao dao;
	
	@BeforeClass
	public static void setup(){
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("file:/Users/fredfu/Workspace/EclipseWorkspace/fastpublish/src/main/webapp/WEB-INF/fastpublish-servlet.xml");
		dao = (JdbcProductDao)ctx.getBean("jdbcProductDao");
		ctx.close();
	}

	@Before
	public void prepare(){
		
	}
	
	@Test
	public void testAddProduct(){
		Product p = new Product();
		p.setName("Lexis Red");
		dao.addProduct(p);
	}
	
	@Test
	public void testGetAll(){
		System.out.println(dao.getAll());
	}
	
	@AfterClass
	public static void tearDown(){
		
	}
	
}
