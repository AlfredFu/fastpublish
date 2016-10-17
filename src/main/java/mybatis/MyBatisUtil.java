package mybatis;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil {

	private final static SqlSessionFactory sqlSessionFactory;
	
	static{
		String config = "mybatis/config.xml";
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader(config);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	}
	
	public static SqlSessionFactory getSqlSessionFactory(){
		return sqlSessionFactory;
	}
	
}
