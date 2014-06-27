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
	private int clothes_id ;
	private int number ;
	private int summary_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getClothes_id() {
		return clothes_id;
	}
	public void setClothes_id(int clothes_id) {
		this.clothes_id = clothes_id;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getSummary_id() {
		return summary_id;
	}
	public void setSummary_id(int summary_id) {
		this.summary_id = summary_id;
	}
}
