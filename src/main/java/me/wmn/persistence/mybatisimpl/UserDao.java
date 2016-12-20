package me.wmn.persistence.mybatisimpl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import me.wmn.domain.User;
import me.wmn.domain.UserMapper;
import me.wmn.persistence.IUserDao;

@Repository
public class UserDao implements IUserDao{

	@Autowired
	SqlSession sqlSession;

	@Override
	public User selectById(int id) {
		UserMapper um = this.sqlSession.getMapper(UserMapper.class);
		return um.selectById(id);
	}

	@Override
	public void deleteById(int id) {
		UserMapper um = this.sqlSession.getMapper(UserMapper.class);
		um.deleteById(id);
	}

	@Override
	public List<User> getAll() {
		UserMapper um = this.sqlSession.getMapper(UserMapper.class);
		return um.getAll();
	}

	@Override
	public void update(User user) {
		UserMapper um = this.sqlSession.getMapper(UserMapper.class);
		um.update(user);
	}

	@Override
	public void add(User user) {
		UserMapper um = this.sqlSession.getMapper(UserMapper.class);
		um.add(user);
	}

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
}
