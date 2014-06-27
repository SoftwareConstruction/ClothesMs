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
public class OrderOutDetail {
	private int id ;
	private Clothes clothes ;
	private int number ;
	private OrderOut summary;
	
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
	public OrderOut getSummary() {
		return summary;
	}
	public void setSummary(OrderOut summary) {
		this.summary = summary;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
