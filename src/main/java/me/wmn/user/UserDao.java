package me.wmn.user;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("securityUserDao")
public class UserDao implements IUserDao {
	
	@Autowired
	private SqlSession sqlSession;
		
	public UserDao(){
	}
	
	public UserDao(SqlSession sqlSession){
		this.sqlSession = sqlSession;
	}
	
	public User getUser(String username){
		UserMapper um = this.sqlSession.getMapper(UserMapper.class);
		return um.getUser(username);
	}
	
	public void addUser(User user){
		if(user != null){
			UserMapper um = this.sqlSession.getMapper(UserMapper.class);
			um.addUser(user);
		}
	}
	
	public void deleteAll(){
		UserMapper um = this.sqlSession.getMapper(UserMapper.class);
		um.deleteAll();
	}
	

	public SqlSession getSqlSession() {
		return sqlSession;
	}

	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
		
}
