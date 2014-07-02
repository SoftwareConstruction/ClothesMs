/**
 *@Copyright:Copyright (c) 2014
 */
package com.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.entity.Clothes;
import com.entity.OrderIn;
import com.entity.OrderInDetail;
import com.opensymphony.xwork2.ActionContext;
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
	public int orderInId;
	private int orderInDetailId;
	
	public String save(){
		ActionContext actionContext = ActionContext.getContext();
		OrderInDetail orderInDetail = new OrderInDetail();
		
		Clothes clothes = new Clothes();
		clothes.setDocuNum(docuNum);
		orderInDetail.setClothes(clothes);
		
		OrderIn summary = new OrderIn();
		summary.setOrderId(orderInId);
		orderInDetail.setSummary(summary);
		
		orderInDetail.setNumber(account);
		String error = orderInDetailServiceImpl.add(orderInDetail);
		if(error == null){
			return "orderInDetail_save_SUCCESS";
		}
		actionContext.put("error", error);
		return "orderInDetail_save_ERROR";	
	}
	
	public String delete(){
		ActionContext actionContext = ActionContext.getContext();
		OrderInDetail orderInDetail = new OrderInDetail();
		orderInDetail.setId(orderInDetailId);
		
		Clothes clothes = new Clothes();
		clothes.setDocuNum(docuNum);
		orderInDetail.setClothes(clothes);
		
		OrderIn summary = new OrderIn();
		summary.setOrderId(orderInDetailId);
		orderInDetail.setSummary(summary);
		
		String error = orderInDetailServiceImpl.delete(orderInDetail);
		
		if(error == null){
			return "orderInDetail_delete_SUCCESS";
		}
		
		actionContext.put("error", error);
		return "orderInDetail_delete_FALSE";
	}
	/**
	 * 查询一个orderIn的所有明细入库单
	 */
	public String list(){
		ActionContext actionContext = ActionContext.getContext();
		List<OrderInDetail> list = orderInDetailServiceImpl.findOrderDerailByOrderDocuNum(docuNum);
		if(list.size() == 0){
			return "orderInDeatil_list_ERROR";
		}else{
			actionContext.put("orderInDetail_list", list);
			return "orderInDeatil_list_SUCCESS";
		}
		
	}

	public String getDocuNum() {
		return docuNum;
	}
	public void setDocuNum(String docuNum) {
		this.docuNum = docuNum;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public int getOrderInId() {
		return orderInId;
	}
	public void setOrderInId(int orderInId) {
		this.orderInId = orderInId;
	}
	public int getOrderInDetailId() {
		return orderInDetailId;
	}

	public void setOrderInDetailId(int orderInDetailId) {
		this.orderInDetailId = orderInDetailId;
	}
}
