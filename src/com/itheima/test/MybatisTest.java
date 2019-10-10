package com.itheima.test;

import com.itheima.po.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {
    @Test
    public void findCustomerByIdTest() throws IOException {
        String resource="mybatis-config.xml";
        InputStream inputStream= Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Customer customer=sqlSession.selectOne("com.itheima.mapper"+".CustomerMapper.findCustomerById",1);
        System.out.println(customer.toString());
        sqlSession.close();

    }

}
