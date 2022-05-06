package com.trans_action.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration // �������Ϸ� ���
@ComponentScan(basePackages = {"com.trans_action.repository"})
public class RootContext {
	
	@Bean
	public BasicDataSource dataSource() { // mysql ������ ���� dataSource bean ���
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ssm");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		return dataSource;
	}
   
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception { // mybatis ����� ���� sessionFactory bean ���
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		sqlSessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml")); // mybatis �������� ���
		return sqlSessionFactory;
	}
   
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactoryBean sqlsessionFactory) throws Exception { // mybatis ����� ���� sqlSession bean ���
		return new SqlSessionTemplate(sqlsessionFactory.getObject());
	}
}