package mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import me.wmn.domain.Product;

public class TestMyBatis {

		static SqlSessionFactory sqlSessionFactory;
		static{
			sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
		}
		
		public static void testSelect(){
			SqlSession ss = sqlSessionFactory.openSession();
			
			Product p = ss.selectOne("getProductById", new Integer(29));
			
			System.out.println(p.getName() + ",  " +p.getDescription());
			
			ss.close();
		}
		
		public static void main(String[] args){
			testSelect();
		}
}
