/**
 *@Copyright:Copyright (c) 2014
 */
package com.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.entity.OrderIn;
import com.opensymphony.xwork2.ActionSupport;
import com.service.OrderInService;

/**
 *@Author kklt21cn
 *@Since 2014年6月26日
 *@Version 1.0
 */
@Component("orderIn")
@Scope("prototype")
public class OrderInAction extends ActionSupport{
	@Resource
	private OrderInService orderInServiceImpl;
	
	public OrderIn orderIn;
	public String dateStr ;
	
	public String add(){
		//转化为Date型
		SimpleDateFormat formatDate = new SimpleDateFormat();
		Date time = null;
		try {
			time = formatDate.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		return null;
	}
	

}
