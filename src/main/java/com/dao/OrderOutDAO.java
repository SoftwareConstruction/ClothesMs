/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao;

import java.util.List;

import com.entity.OrderIn;
import com.entity.OrderOut;

/**
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
public interface OrderOutDAO {
	public void add(OrderOut orderOut);
	public void updateFlag(OrderOut orderOut);
	public void update(OrderOut orderOut);
	public List<OrderOut> findById(int id);
	public List<OrderOut> findAllByPaging(int firstIndex,int size);
	public List<OrderOut> findByDocuNum(String docuNum);
	public int getAccount();
}
