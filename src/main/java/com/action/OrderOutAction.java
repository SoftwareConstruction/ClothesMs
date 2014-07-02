/**
 *@Copyright:Copyright (c) 2014
 */
package com.action;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.entity.Admin;
import com.entity.OrderOut;
import com.entity.WareHouse;
import com.opensymphony.xwork2.ActionContext;
import com.service.OrderOutService;
import com.util.StringToDateUtil;

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
	public String orderId;
	public Admin manager;

	public String save() {
		ActionContext actionContext = ActionContext.getContext();
		OrderOut orderOut = new OrderOut();
		orderOut.setFlag(1);
		
		manager = (Admin) actionContext.get("LoginAdmin");
		orderOut.setManager(manager);
		String error = orderOutServiceImpl.save(orderOut);
		if(error == null){
			return "orderOut_save_SUCCESS";
		}
		actionContext.put("error", error);
		return "orderOut_save_FALSE";
	}
	
	public String delete(){
		ActionContext actionContext = ActionContext.getContext();
		OrderOut orderOut = new OrderOut();
		orderOut.setOrderId(Integer.parseInt(orderId));
		
		String error = orderOutServiceImpl.delete(orderOut);
		if(error == null){
			return "orderOut_delete_SUCCESS";
		}
		actionContext.put("error", error);
		return "orderOut_delete_ERROR";
	}
	
	public String update(){
		ActionContext actionContext = ActionContext.getContext();
		OrderOut orderOut  = new OrderOut();
		orderOut.setFlag(1);
		
		
		manager = (Admin) actionContext.get("LoginAdmin");
		orderOut.setManager(manager);
		orderOut.setOrderId(Integer.parseInt(orderId));
		
		StringToDateUtil util = new StringToDateUtil();
		Date out_time = util.toDate(dateStr);
		
		orderOut.setOut_time(out_time);
		orderOut.setFlag(1);
		orderOut.setSend(send);
		
		WareHouse wareHouse = new WareHouse();
		wareHouse.setName(wareHouseName);
		orderOut.setWareHouse(wareHouse);
		
		String error = orderOutServiceImpl.update(orderOut);
		
		if(error == null){
			return "orderOut_update_SUCCESS";
		}
		actionContext.put("error", error);
		return "orderOut_update_ERROR";
	}
	
	public String list(){
		ActionContext actionContext = ActionContext.getContext();
		List<OrderOut> orderOuts = orderOutServiceImpl.findByAllPaging(0, 15);
		
		if (orderOuts.size() > 0) {
			System.out.println("查询成功！");
			actionContext.put("orderOuts", orderOuts);
			return "orderOut_list_SUCCESS";
		} else {
			System.out.println("查询失败！");
			return "orderOut_list_ERROR";
		}
		
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
