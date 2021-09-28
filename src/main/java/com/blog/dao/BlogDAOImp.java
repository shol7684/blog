package com.blog.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BlogDAOImp {

	@Autowired
	private SqlSession sql;
	
	private static String namespace = "com.blog.dao.BlogDAO";
	
	
}
