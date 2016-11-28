package me.mwn.persistence;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import me.wmn.domain.Product;
import me.wmn.persistence.jdbcimpl.JdbcProductDao;

public class IProductDaoTest {
	
	JdbcProductDao dao;

	@Before
	public void prepare(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("file:/Users/fredfu/Workspace/EclipseWorkspace/fastpublish/src/main/webapp/WEB-INF/fastpublish-servlet.xml");
		dao = (JdbcProductDao)ctx.getBean("jdbcProductDao");
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
	
}
