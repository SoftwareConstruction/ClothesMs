/**
 *@Copyright:Copyright (c) 2014
 */
package com.service.impl;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Admin;
import com.entity.Clothes;
import com.entity.OrderOut;
import com.entity.WareHouse;
import com.service.OrderOutService;

/**
 *@Author kklt21cn
 *@Since 2014年6月26日
 *@Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrderOutServiceImplTest {
	@Resource
	private OrderOutService orderOutServiceImpl;
	private OrderOut orderOut = null;
	@Before
	public void before(){
		orderOut = new OrderOut();
		orderOut.setDocu_number("docunum1");
		orderOut.setFlag(1);
		orderOut.setNumber(100);
		orderOut.setSend("中国");
		
		Admin admin = new Admin();
		admin.setId(5);
		
		WareHouse wareHouse = new WareHouse();
		wareHouse.setName("name1");
		
		orderOut.setManager(admin);
		orderOut.setWareHouse(wareHouse);
	}
	
	
	@Test
	public void add(){
		String result = orderOutServiceImpl.save(orderOut);
		assertThat(result,nullValue());
	}
	
	@Test
	public void delete(){
		orderOutServiceImpl.delete(orderOut);
	}
	
	@Test
	public void update(){
		orderOutServiceImpl.update(orderOut);
	}
	
}
