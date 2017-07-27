package me.wmn.persistence.mybatisimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.wmn.domain.Product;
import me.wmn.domain.Version;
import me.wmn.persistence.IProductDao;

@Repository
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
		return this.sqlSession.selectList("me.wmn.persistence.mybatisimpl.MyBatisProductDao.getAll");
	}

	public boolean deleteProductById(Integer id) {
		this.sqlSession.delete("deleteProductById", id);
		return true;
	}

	public Product getProductByID(Integer id) {
//		List<Product> productList = this.sqlSession.selectList("getProductById", id);
//		return (productList != null && productList.size() > 0) ? productList.get(0) : null;
		Product p = this.sqlSession.selectOne("getProductById", id);
		if(p != null && p.getVersionList() != null){
			List<Version> versions = p.getVersionList();
			if(versions.size() == 1 && versions.get(0).getId() == null){
				versions.remove(0);
			}
		}
		return p;
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

	@Override
	public boolean updateProduct(Product product) {
		return this.sqlSession.update("updateProduct", product) > 0;
	}

	
}
