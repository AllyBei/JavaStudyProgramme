package cn.hrs.allybei.JavaStudy.SpringBoot;

import cn.hrs.allybei.JavaStudy.SpringBoot.mybatisTest.mapper.UserMapper;
import cn.hrs.allybei.JavaStudy.SpringBoot.mybatisTest.model.User;
import cn.hrs.allybei.JavaStudy.SpringBoot.utils.DbUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;

@SpringBootTest
class JavaStudyApplicationTests {

	@Test
	void contextLoads() {

		// Create a test sql session
		SqlSession sqlSession = null;
		try{
			sqlSession= DbUtils.openSqlSession();

			// Load Mapper configuration
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

			// Get user info with
			User user = userMapper.getUser(1l);

			List<User> users = userMapper.getUsers();

			System.out.println(user);

			Iterator iterator = users.iterator();
			while(iterator.hasNext()){
				System.out.println(iterator.next());
			}

		}catch(Exception e){
			e.printStackTrace();
			sqlSession.rollback();
		}finally {
			sqlSession.close();
		}


	}

}
