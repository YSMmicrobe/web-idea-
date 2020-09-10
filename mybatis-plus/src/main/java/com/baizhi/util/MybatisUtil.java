package com.baizhi.util;

import com.baomidou.mybatisplus.MybatisSessionFactoryBuilder;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtil {
	private static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
			sqlSessionFactory = new MybatisSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static SqlSession getSqlSession() {
		SqlSession session = sqlSessionFactory.openSession();
		return session;
	}
	public static void closeSession(SqlSession session) {
		if(session != null) session.close();
	}
}
