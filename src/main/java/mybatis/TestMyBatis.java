package mybatis;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import me.wmn.domain.Product;
import me.wmn.persistence.mybatisimpl.MybatisProductDao;

public class TestMyBatis {

		static SqlSessionFactory sqlSessionFactory;
		static{
			sqlSessionFactory = MyBatisUtil.getSqlSessionFactory();
		}
		
		public static void testSelect(){
			SqlSession ss = sqlSessionFactory.openSession();
			
			MybatisProductDao mpd = ss.getMapper(MybatisProductDao.class);
			Product p = mpd.getProductById(29);
			System.out.println(p.getName() + ",  " +p.getDescription());
		}
		
		public static void main(String[] args){
			testSelect();
		}
}
