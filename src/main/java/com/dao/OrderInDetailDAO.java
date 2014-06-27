/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao;

import java.util.List;

import com.entity.OrderInDetail;

/**
 *@Author kklt21cn
 *@Since 2014年6月26日
 *@Version 1.0
 */
public interface OrderInDetailDAO {
	public void add(OrderInDetail orderInDetail);
	public void update(OrderInDetail orderInDetail);
	public List<OrderInDetail> findByOrderInID(int orderInID);
}
