/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao.impl;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.OrderOutDetailDAO;
import com.entity.Clothes;
import com.entity.OrderOut;
import com.entity.OrderOutDetail;

/**
 *@Author kklt21cn
 *@Since 2014年6月27日
 *@Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class OrderOutDetailDAOImplTest {
	@Resource
	private OrderOutDetailDAO orderOutDetailDAOImpl;
	private OrderOutDetail orderOutDetail;
	@Before
	public void before(){
		orderOutDetail = new OrderOutDetail();
		orderOutDetail.setNumber(200000);
		Clothes clothes = new Clothes();
		clothes.setId(5);
		OrderOut summary = new OrderOut();
		summary.setOrderId(1);
		orderOutDetail.setClothes(clothes);
		orderOutDetail.setSummary(summary);
	}
	
	@Test
	public void add(){
		orderOutDetailDAOImpl.add(orderOutDetail);
	}
	
	@Test
	public void delete(){
		orderOutDetail.setId(1);
		orderOutDetailDAOImpl.delete(orderOutDetail);
	}
}
