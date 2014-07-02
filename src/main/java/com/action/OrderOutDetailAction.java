/**
 *@Copyright:Copyright (c) 2014
 */
package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.entity.Clothes;
import com.entity.OrderOut;
import com.entity.OrderOutDetail;
import com.opensymphony.xwork2.ActionContext;
import com.service.OrderOutDetailService;

/**
 *@Author kklt21cn
 *@Since 2014年7月2日
 *@Version 1.0
 */
@Component("orderOutDetail")
@Scope("prototype")
public class OrderOutDetailAction {
	@Resource
	private OrderOutDetailService orderOutDetailServiceImpl;
	
	public int orderOutDetailId;
	public String docuNum;
	public String color;
	public String size;
	public String account;
	public int orderId;
	
	private ActionContext actionContext = ActionContext.getContext();
	
	
	public String save(){
		OrderOutDetail orderOutDetail = new OrderOutDetail();
		
		Clothes clothes = new Clothes();
		clothes.setDocuNum(docuNum);
		clothes.setColor(color);
		clothes.setSize(Integer.parseInt(size));
		orderOutDetail.setClothes(clothes);
		
		orderOutDetail.setNumber(Integer.parseInt(account));
		OrderOut summary = new OrderOut();
		summary.setOrderId(orderId);
		orderOutDetail.setSummary(summary);
		
		String error = orderOutDetailServiceImpl.save(orderOutDetail);
		if(error == null){
			return list();
		}
		return "orderOutDetail_save_SUCCESS";
	}
	
	public String delete(){
		OrderOutDetail orderOutDetail = new OrderOutDetail();
		orderOutDetail.setId(orderOutDetailId);
		
		Clothes clothes = new Clothes();
		clothes.setDocuNum(docuNum);
		orderOutDetail.setClothes(clothes);
		
		OrderOut summary = new OrderOut();
		summary.setOrderId(orderId);
		orderOutDetail.setSummary(summary);
		
		String error = orderOutDetailServiceImpl.delete(orderOutDetail);
		if(error == null){
			return list();
		}
		actionContext.put("error", error);
		return "orderOutDetail_delete_ERROR";
	}
	
	
	public String list(){
		List<OrderOutDetail> orderDetail_list = orderOutDetailServiceImpl.findByOrderId(orderId); 
		if(orderDetail_list.size() == 0){
			return "orderOutDetail_list_ERROR";
		}
		actionContext.put("orderDetail_list", orderDetail_list);
		return "orderOutDetail_list_SUCCESS";
	}
}
