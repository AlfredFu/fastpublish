package me.wmn.persistence.mybatisimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import me.wmn.domain.OSPackage;
import me.wmn.persistence.IPackageDao;

@Component
public class MyBatisPackageDao implements IPackageDao {
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public void savePackage(OSPackage osp) {
		this.sqlSession.insert("savePackage", osp);
	}

	@Override
	public void deleteById(int id) {
		this.sqlSession.delete("deleteById", id);
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<OSPackage> getByProductId(int productId) {
		return this.sqlSession.selectList("me.wmn.persistence.mybatisimpl.MyBatisPackageDao.getByProductId", productId);
	}

	@Override
	public OSPackage getById(int id) {
		return this.sqlSession.selectOne("me.wmn.persistence.mybatisimpl.MyBatisPackageDao.getById", id);
	}
	
	public void deleteByVersionId(int versionId){
		this.sqlSession.delete("me.wmn.persistence.mybatisimpl.MyBatisPackageDao.deleteByVersionId", versionId);
	}

	
}
