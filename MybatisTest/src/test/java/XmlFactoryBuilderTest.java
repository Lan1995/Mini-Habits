package java;

import dao.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class XmlFactoryBuilderTest {


  @Test
  public void testInputStream() {
    String file = "src/main/resources/mybatis-config.xml";
    SqlSession sqlSession = null;
    try {
      InputStream inputStream = Resources.getResourceAsStream(file);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
      sqlSession = sqlSessionFactory.openSession();
      UserMapper mapper = sqlSession.getMapper(UserMapper.class);
      //...
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (null != sqlSession) {
        sqlSession.close();
      }
    }
  }
}
