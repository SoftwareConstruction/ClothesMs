/**
 *@Copyright:Copyright (c) 2014
 */
package com.service;

import java.util.List;

import com.entity.OrderIn;

/**
 *@Author kklt21cn
 *@Since 2014年6月20日
 *@Version 1.0
 */
public interface OrderInService {
	/**
	 * @param orderIn 在orderIn中，必须封装有WareHouse和Admin，以及Clothes类。
	 * 	其中WareHouse类里的name属性不能为空，其他属性可为空
	 *  Admin类的实例为当前进行此操作的管理员的实例
	 *  Clothes类中的docu_number属性不能为空，其他属性可为空
	 * @return 返回的String类型为错误信息，如果没有错误信息，则为空
	 * @Description 
	 */
	public String save(OrderIn orderIn);
	public String update(OrderIn orderIn);
	/**
	 * 
	 * @param orderIn 里面要封装有要删除的id
	 * @return
	 * @Description
	 */
	public String delete(OrderIn orderIn);
	public OrderIn findById(int id);
	public List<OrderIn> findAllByPaging(int first,int size);
	public OrderIn findByDocuNum(String docuNum);
	public int getAccount();
}
