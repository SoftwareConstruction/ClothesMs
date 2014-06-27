/**
 *@Copyright:Copyright (c) 2014
 */
package com.service;

import java.util.List;

import com.entity.OrderInDetail;

/**
 *@Author kklt21cn
 *@Since 2014年6月27日
 *@Version 1.0
 */

public interface OrderInDetailService {
	public String add(OrderInDetail orderInDetail);
	public String delete(OrderInDetail orderInDetail);
	public List<OrderInDetail> findOrderDerailByOrderDocuNum(String docuNum);
}
