package com.trans_action.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration // 설정파일로 등록
@ComponentScan(basePackages = {"com.trans_action.repository"})
public class RootContext {
	
	@Bean
	public BasicDataSource dataSource() { // mysql 연동을 위한 dataSource bean 등록
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ssm");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		return dataSource;
	}
   
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception { // mybatis 사용을 위한 sessionFactory bean 등록
		SqlSessionFactoryBean sqlSessionFactory = new SqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource());
		sqlSessionFactory.setConfigLocation(new PathMatchingResourcePatternResolver().getResource("classpath:mybatis-config.xml")); // mybatis 설정파일 등록
		return sqlSessionFactory;
	}
   
	@Bean
	public SqlSessionTemplate sqlSession(SqlSessionFactoryBean sqlsessionFactory) throws Exception { // mybatis 사용을 위한 sqlSession bean 등록
		return new SqlSessionTemplate(sqlsessionFactory.getObject());
	}
}