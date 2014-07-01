/**
 *@Copyright:Copyright (c) 2014
 */
package com.service;

import java.util.List;

import com.entity.OrderOutDetail;

/**
 *@Author kklt21cn
 *@Since 2014年6月28日
 *@Version 1.0
 */
public interface OrderOutDetailService {
	public String save(OrderOutDetail orderOutDetail);
	/**
	 * 
	 * @param orderOutDetail 其中必须封装clothes和OrderOut，
	 * 			其中的clothes要封装有docu
	 * 			而orderOut要封装有Id
	 * @return 错误的信息，为空即没有异常
	 * @Description
	 */
	public String delete(OrderOutDetail orderOutDetail);
	public String update(OrderOutDetail orderOutDetail);
	public List<OrderOutDetail> findByOrderId(int orderOutId); 
}
