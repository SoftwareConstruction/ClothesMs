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
import com.entity.OrderIn;
import com.entity.WareHouse;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.service.OrderInService;
import com.util.StringToDateUtil;

/**
 *@Author kklt21cn
 *@Since 2014年6月26日
 *@Version 1.0
 */
@Component("orderIn")
@Scope("prototype")
public class OrderInAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	@Resource
	private OrderInService orderInServiceImpl;
	public String docuNum;
	public String remark;
	public String wareHouse_name;
	public String source;
	public String dateStr ;
	public String id;
	
	
	public String add(){
		//转化为Date型
		StringToDateUtil util = new StringToDateUtil();
		Date time = util.toDate(dateStr);
		
		
		//取得seesion，并把里面的管理员取出
		ActionContext actionContext = ActionContext.getContext();
		Admin manager = (Admin) actionContext.getSession().get("LoginAdmin");
		
		WareHouse wareHouse = new WareHouse();
		wareHouse.setName(wareHouse_name);
		
		OrderIn orderIn= new OrderIn();
		orderIn.setFlag(1);
		orderIn.setManager(manager);
		orderIn.setRemark(remark);
		orderIn.setSource(source);
		orderIn.setIn_time(time);
		orderIn.setWareHouse(wareHouse);
		
		String error = orderInServiceImpl.save(orderIn);
		if(error == null){
			return "orderIn_add_SUCCESS";
		}else{
			ActionContext actionAction = ActionContext.getContext();
			actionAction.put("error", error);
			return "orderIn_add_ERROR";
		}
	}
	
	
	
	public String update(){
		//取得seesion，并把里面的管理员取出
		ActionContext actionContext = ActionContext.getContext();
		Admin manager = (Admin)actionContext.getSession().get("LoginAdmin");
		
		//转化为Date型
		StringToDateUtil util = new StringToDateUtil();
		Date time = util.toDate(dateStr);		
		
		WareHouse wareHouse = new WareHouse();
		wareHouse.setName(wareHouse_name);
		
		OrderIn orderIn= new OrderIn();
		orderIn.setOrderId(Integer.parseInt(id));
		orderIn.setDocu_number(docuNum);
		orderIn.setFlag(1);
		orderIn.setManager(manager);
		orderIn.setRemark(remark);
		orderIn.setSource(source);
		orderIn.setIn_time(time);
		orderIn.setWareHouse(wareHouse);
		
		String error = orderInServiceImpl.update(orderIn);
		if(error==null){
			return "orderIn_update_SUCCESS";
		}
		ActionContext actionAction = ActionContext.getContext();
		actionAction.put("error", error);
		return "orderIn_update_ERROR";
	}
	
	
	public String delete(){
		OrderIn orderIn = new OrderIn();
		orderIn.setOrderId(Integer.parseInt(id));
		
		String error = orderInServiceImpl.delete(orderIn);
		if(error == null){
			return "orderIn_update_SUCCESS";
		}
		ActionContext actionAction = ActionContext.getContext();
		actionAction.put("error", error);
		return "orderIn_update_ERROR";
	}
	
	public String list(){
		List<OrderIn> orderIn_list = orderInServiceImpl.findAllByPaging(0, 15);
		if(orderIn_list.size() == 0){
			return "orderIn_list_SUCCESS";
		}
		ActionContext actionContext = ActionContext.getContext();
		actionContext.put("orderIn_list", orderIn_list);
		return "orderIn_list_SUCCESS";
	}


	//get、set方法
	public String getDocuNum() {
		return docuNum;
	}
	public void setDocuNum(String docuNum) {
		this.docuNum = docuNum;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getWareHouse_name() {
		return wareHouse_name;
	}
	public void setWareHouse_name(String wareHouse_name) {
		this.wareHouse_name = wareHouse_name;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
