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
	/**
	 * 
	 * @param orderInDetail 里面封装的clothes和OrderIn。
	 * 		  其中clothes的docuNum(编号)不能为空
	 * 		   OrderIn的Id不能为空
	 * @return 
	 * @Description
	 */
	public String add(OrderInDetail orderInDetail);
	/**
	 * 
	 * @param orderInDetail 里面封装的clothes和OrderIn。
	 * 		  其中clothes的docuNum(编号)不能为空
	 * 		   OrderIn的Id不能为空
	 * 		orderInDetail也要有id;
	 * @return 
	 * @Description
	 */
	public String delete(OrderInDetail orderInDetail);
	public List<OrderInDetail> findOrderDerailByOrderDocuNum(String docuNum);
}
