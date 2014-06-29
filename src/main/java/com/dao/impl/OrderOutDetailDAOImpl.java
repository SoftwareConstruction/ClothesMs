/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.OrderOutDAO;
import com.dao.OrderOutDetailDAO;
import com.entity.OrderInDetail;
import com.entity.OrderOut;
import com.entity.OrderOutDetail;

/**
 *@Author kklt21cn
 *@Since 2014年6月27日
 *@Version 1.0
 */
@SuppressWarnings("unchecked")
@Component
public class OrderOutDetailDAOImpl implements OrderOutDetailDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void add(OrderOutDetail orderOutDetail) {
		hibernateTemplate.save(orderOutDetail);
		
	}
	@Override
	public void update(OrderOutDetail orderOutDetail) {
		hibernateTemplate.update(orderOutDetail);
	}

	@Override
	public List<OrderOutDetail> findByOrderOutID(int orderOutID) {
		List<OrderOutDetail> result = (List<OrderOutDetail>) hibernateTemplate.find("from OrderOutDetail as o where o.summary.id=?", orderOutID);
		return result;
	}

	@Override
	public List<OrderOutDetail> findByClothesIdAndOrderInId(int clothesId,
			int orderInId) {
		List<OrderOutDetail> result = (List<OrderOutDetail>) hibernateTemplate.find("from OrderOutDetail as o where o.clothes.id  =? and o.summary.id=?",clothesId, orderInId);
		return result;
	}

	@Override
	public void delete(OrderOutDetail orderOutDetail) {
		hibernateTemplate.delete(orderOutDetail);
	}
	
	@Override
	public List<OrderOutDetail> getById(int id) {
		List<OrderOutDetail> result = (List<OrderOutDetail>) hibernateTemplate.find("from OrderOutDetail as o where o.id  =? ",id);
		return result;
	}
	

}
