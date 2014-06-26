/**
 *@Copyright:Copyright (c) 2014
 */
package com.entity;

import java.util.Date;

/**实体类
 *@Auth  kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
public class OrderOut {
	private int orderId;
	private String docu_number;
	private WareHouse wareHouse;
	private Date out_time;
	private Admin manager;
	private String send;
	public String getSend() {
		return send;
	}

	public void setSend(String send) {
		this.send = send;
	}
	private int flag;
	private int number;
	private Clothes clothes;
	
	public OrderOut(){
		this.out_time = new Date();
		out_time.getTime();
	}
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getDocu_number() {
		return docu_number;
	}
	public void setDocu_number(String docu_number) {
		this.docu_number = docu_number;
	}
	public Date getOut_time() {
		return out_time;
	}
	public void setOut_time(Date out_time) {
		this.out_time = out_time;
	}
	public WareHouse getWareHouse() {
		return wareHouse;
	}
	public void setWareHouse(WareHouse wareHouse) {
		this.wareHouse = wareHouse;
	}
	public Admin getManager() {
		return manager;
	}
	public void setManager(Admin manager) {
		this.manager = manager;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Clothes getClothes() {
		return clothes;
	}
	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}
	
}
