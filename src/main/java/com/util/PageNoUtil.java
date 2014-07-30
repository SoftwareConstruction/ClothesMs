package com.util;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

public class PageNoUtil {
	public static List<?> getList(Session session,String hql , int firstIndex,int size){
		Query query = session.createQuery(hql).setFirstResult(firstIndex).setMaxResults(size);
		List<?> list = query.list();
		return list;
	}
	
	public static int size=10;
	
	public static int getPageAccount(int account){
		int remainder = account%size;
		if(remainder!=0){
			return account/size+1;
		}else{
			return account/size;
		}
	}
}
