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
		
		Clothes clothes = new Clothes();
		clothes.setId(6);
		clothes.setColor("蓝色");
		clothes.setCommodity_name("中款大衣");
		clothes.setDocuNum("docu2");
		clothes.setEx_factory_price(450);
		clothes.setFlag(100);
		clothes.setIn_material("布");
		clothes.setOut_material("尼龙");
		clothes.setRetail_price(800);
		clothes.setSize(150);
		
		Admin admin = new Admin();
		admin.setIntroduction("123");
		admin.setName("bin");
		admin.setPassword("123344445");
		admin.setUsername("bin");
		admin.setId(5);
		
		WareHouse wareHouse = new WareHouse();
		wareHouse.setId(4);
		wareHouse.setContact("李四");
		wareHouse.setContact_phone("122222");
		wareHouse.setDocu_number("10001");
		wareHouse.setFlag(1);
		wareHouse.setName("name1");
		wareHouse.setTotal_storage(800);
		
		
		
		
		orderOut.setClothes(clothes);
		orderOut.setManager(admin);
		orderOut.setWareHouse(wareHouse);
	}
	
	
	@Test
	public void add(){
		String result = orderOutServiceImpl.save(orderOut);
		assertThat(result,nullValue());
	}
}
