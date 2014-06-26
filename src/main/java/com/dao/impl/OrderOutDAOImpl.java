/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.OrderOutDAO;
import com.entity.OrderIn;
import com.entity.OrderOut;
import com.util.GetAccountWithHibernateCallback;
import com.util.PageNoUtil;

/**
 *@Author kklt21cn
 *@Since 2014年6月25日
 *@Version 1.0
 */
@SuppressWarnings("unchecked")
@Component
public class OrderOutDAOImpl implements OrderOutDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void add(OrderOut orderOut) {
		hibernateTemplate.save(orderOut);
		
	}

	@Override
	public void updateFlag(OrderOut orderOut) {
		hibernateTemplate.update(orderOut);
	}

	@Override
	public void update(OrderOut orderOut) {
		hibernateTemplate.update(orderOut);
	}

	
	@Override
	public List<OrderOut> findById(int id) {
		List<OrderOut> result = (List<OrderOut>) hibernateTemplate.find("from OrderOut as o whehre o.orderId=?", id);
		return result;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<OrderOut> findAllByPaging(final int firstIndex,final int size) {
		List<OrderOut> result = hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				String hql = "from OrderIn as a";
				List<?> result = PageNoUtil.getList(session, hql, firstIndex, size);
				return result;
			}
		});
		return result;
	}

	@Override
	public List<OrderOut> findByDocuNum(String docuNum) {
		List<OrderOut> result = (List<OrderOut>) hibernateTemplate.find("from OrderOut as o where o.docu_number",docuNum);
		return result;
	}


	@Override
	public int getAccount() {
		Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
		int result = (int) new GetAccountWithHibernateCallback("OrderOut").doInHibernate(session);
		return result;
	}

}
