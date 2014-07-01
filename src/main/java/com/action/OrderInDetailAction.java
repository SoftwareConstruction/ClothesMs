/**
 *@Copyright:Copyright (c) 2014
 */
package com.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.entity.OrderInDetail;
import com.opensymphony.xwork2.ActionSupport;
import com.service.OrderInDetailService;

/**
 *@Author kklt21cn
 *@Since 2014年7月1日
 *@Version 1.0
 */
@Component("orderInDetail")
@Scope("prototype")
public class OrderInDetailAction extends ActionSupport {
	@Resource
	private OrderInDetailService orderInDetailServiceImpl;
	public String docuNum;
	public String color;
	public int size;
	public int account;
	
	
	public String save(){
		OrderInDetail orderInDetail = new OrderInDetail();
		
		
		
		return "orderInDetail_save_SUCCESS";
	}
	
	
}
