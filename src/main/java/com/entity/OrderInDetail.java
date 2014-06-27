/**
 *@Copyright:Copyright (c) 2014
 */
package com.entity;

/**实体类，对应T_orderIn_detail表
 *@Author kklt21cn
 *@Since 2014年6月26日
 *@Version 1.0
 */
public class OrderInDetail {
	private int id ;
	private Clothes clothes ;
	private int number ;
	private OrderIn summary;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	
	public Clothes getClothes() {
		return clothes;
	}
	public void setClothes(Clothes clothes) {
		this.clothes = clothes;
	}
	public OrderIn getSummary() {
		return summary;
	}
	public void setSummary(OrderIn summary) {
		this.summary = summary;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	
}
