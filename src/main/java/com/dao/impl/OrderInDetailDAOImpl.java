/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.OrderInDetailDAO;
import com.entity.OrderInDetail;

/**
 *@Author kklt21cn
 *@Since 2014年6月26日
 *@Version 1.0
 */
@Component
public class OrderInDetailDAOImpl implements OrderInDetailDAO {
	@Resource
	private HibernateTemplate hibernateTemplate;
	@Override
	public void add(OrderInDetail orderInDetail) {
		hibernateTemplate.save(orderInDetail);
	}

	@Override
	public void update(OrderInDetail orderInDetail) {
		hibernateTemplate.update(orderInDetail);
	}

	@Override
	public List<OrderInDetail> findByOrderInID(int orderInID) {
		List<OrderInDetail> result = (List<OrderInDetail>) hibernateTemplate.find("from OrderInDetail as o where o.summary.id  =?", orderInID);
		return result;
	}

	@Override
	public List<OrderInDetail> findByClothesIdAndOrderInId(int clothesId,
			int orderInId) {
		List<OrderInDetail> result = (List<OrderInDetail>) hibernateTemplate.find("from OrderInDetail as o where o.clothes.id  =? and o.summary.id=?",clothesId, orderInId);
		return result;
	}

	@Override
	public void delete(OrderInDetail orderInDetail) {
		hibernateTemplate.delete(orderInDetail);
	}

}
