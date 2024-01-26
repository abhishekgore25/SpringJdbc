package com.mavenproject;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import dao.jdbc;

public class configjdbc {

	@Bean("ds")
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/newdb");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	@Bean("jt")
	public JdbcTemplate getJdbcTemp() {
		JdbcTemplate temp=new JdbcTemplate(getDataSource());
		return temp;
	}
	@Bean("jdbcdao")
	public jdbc getjdbc() {
		jdbc temp=new jdbc();
		temp.setjdbctemp(getJdbcTemp());
		return temp;
	}
}
