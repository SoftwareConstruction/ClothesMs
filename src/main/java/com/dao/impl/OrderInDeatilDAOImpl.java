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
public class OrderInDeatilDAOImpl implements OrderInDetailDAO {
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
		List<OrderInDetail> result = (List<OrderInDetail>) hibernateTemplate.find("from OrderInDeatail as o where o.clothes_id  =?", orderInID);
		return result;
	}

}
