/**
 *@Copyright:Copyright (c) 2014
 */
package com.service.impl;

import javax.annotation.Resource;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Clothes;
import com.entity.OrderOut;
import com.entity.OrderOutDetail;
import com.service.OrderOutDetailService;

/**
 *@Author kklt21cn
 *@Since 2014年6月28日
 *@Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrderOutDetailServiceImplTest {
	@Resource
	private OrderOutDetailService  orderOutDetailServiceImpl;
	private OrderOutDetail orderOutDetail;
	@Before
	public void before(){
		orderOutDetail = new OrderOutDetail();
		orderOutDetail.setNumber(2);
		
		Clothes clothes = new Clothes();
		clothes.setDocuNum("docu2");
		OrderOut summary = new OrderOut();
		summary.setOrderId(2);
		orderOutDetail.setClothes(clothes);
		orderOutDetail.setSummary(summary);
	}
	
	
	
	@Test
	public void save(){
		String result = orderOutDetailServiceImpl.save(orderOutDetail);
		assertThat(result,nullValue());
	}
	
	@Test
	public void delete(){
		orderOutDetail.setId(1);
		orderOutDetailServiceImpl.delete(orderOutDetail);
	}
	
}
