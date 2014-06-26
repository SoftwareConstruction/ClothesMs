/**
 *@Copyright:Copyright (c) 2014
 */
package com.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.entity.OrderIn;
import com.opensymphony.xwork2.ActionSupport;

/**
 *@Author kklt21cn
 *@Since 2014年6月26日
 *@Version 1.0
 */
@Component("orderIn")
@Scope("prototype")
public class OrderInAction extends ActionSupport{
	public OrderIn orderIn ;
	
	public String add(){
		
		return null;
	}
	

}
