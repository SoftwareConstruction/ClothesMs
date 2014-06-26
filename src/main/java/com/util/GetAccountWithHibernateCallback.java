/**
 *@Copyright:Copyright (c) 2014
 */
package com.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

/**
 *@Author kklt21cn
 *@Since 2014年6月26日
 *@Version 1.0
 */
public class GetAccountWithHibernateCallback implements HibernateCallback{
	private String classname = null;
	
	public GetAccountWithHibernateCallback(String classname){
		this.classname=classname;
	}
	
	
	@Override
	public Object doInHibernate(Session session) throws HibernateException {
		String sql = "select count(*) from " + classname + " where flag=1";
		long count =0;
		try{
			count= ((Long) session.createQuery(sql).iterate().next()).intValue();
		}catch(Exception e){
			e.printStackTrace();
		}
		int result = (int)count;
		return result;
	}
}
