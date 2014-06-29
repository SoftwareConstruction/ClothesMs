/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao;

import java.util.List;

import com.entity.OrderInDetail;
import com.entity.OrderOutDetail;

/**
 *@Author kklt21cn
 *@Since 2014年6月27日
 *@Version 1.0
 */
public interface OrderOutDetailDAO {
	public void add(OrderOutDetail orderOutDetail);
	public void update(OrderOutDetail orderOutDetail);
	public List<OrderOutDetail> findByOrderOutID(int orderOutID);
	public List<OrderOutDetail> findByClothesIdAndOrderInId(int clothesId , int orderInId);
	public void delete(OrderOutDetail orderOutDetail);
	public List<OrderOutDetail> getById(int id);
}
