/**
 *@Copyright:Copyright (c) 2014
 */
package com.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.entity.Admin;
import com.entity.OrderOut;
import com.opensymphony.xwork2.ActionContext;
import com.service.OrderOutService;

/**
 * @Author kklt21cn
 * @Since 2014年7月1日
 * @Version 1.0
 */
@Component("orderOut")
@Scope("prototype")
public class OrderOutAction {
	@Resource
	private OrderOutService orderOutServiceImpl;
	public String wareHouseName;
	public String docuNum;
	public String dateStr;
	public String remark;
	public String send;
	public Admin manager;

	public String save() {
		OrderOut orderOut = new OrderOut();
		orderOut.setFlag(1);
		
		ActionContext actionContext =  ActionContext.getContext();
		manager = (Admin) actionContext.get("LoginAdmin");
		orderOut.setManager(manager);
		orderOutServiceImpl.save(orderOut);
		return null;
	}
	
	
	
	

	public String getWareHouseName() {
		return wareHouseName;
	}
	public void setWareHouseName(String wareHouseName) {
		this.wareHouseName = wareHouseName;
	}
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getSend() {
		return send;
	}
	public void setSend(String send) {
		this.send = send;
	}
}
