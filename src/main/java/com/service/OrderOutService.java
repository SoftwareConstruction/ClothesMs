/**
 *@Copyright:Copyright (c) 2014
 */
package com.service;

import java.util.List;

import com.entity.OrderOut;

/**
 *@Author kklt21cn
 *@Since 2014年6月26日
 *@Version 1.0
 */
public interface OrderOutService {
	public abstract String save(OrderOut orderOut);
	public abstract String delete(OrderOut orderOut);
	public abstract String update(OrderOut orderOut);
	public abstract List<OrderOut> findById(OrderOut orderout);
	public abstract List<OrderOut> findByAllPaging();
	public abstract int getAccount();

}
