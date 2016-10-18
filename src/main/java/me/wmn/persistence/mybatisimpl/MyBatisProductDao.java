package me.wmn.persistence.mybatisimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.wmn.domain.Product;
import me.wmn.persistence.IProductDao;

@Component
public class MyBatisProductDao implements IProductDao{

	@Autowired
	private SqlSession sqlSession;
	
	public Product addProduct(Product product) {
		int id = this.sqlSession.insert("addProduct", product);
		System.out.println("return of sqlsession insert():" + id);
		System.out.println(product.getId());
		return product;
	}

	public List<Product> getAll() {
		return this.sqlSession.selectList("getAll");
	}

	public boolean deleteProductById(Integer id) {
		this.sqlSession.delete("deleteProductById", id);
		return true;
	}

	public Product getProductByID(Integer id) {
		return this.sqlSession.selectOne("getProductById", id);
	}

	public boolean saveProduct(Product product) {
		this.sqlSession.insert("addProduct", product);
		return true;
	}

	
	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	
}
