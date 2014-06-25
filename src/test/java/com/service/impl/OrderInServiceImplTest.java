/**
 *@Copyright:Copyright (c) 2014
 */
package com.service.impl;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;




import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import com.entity.Admin;
import com.entity.Clothes;
import com.entity.OrderIn;
import com.entity.WareHouse;
import com.service.OrderInService;

/**
 *@Author kklt21cn
 *@Since 2014年6月22日
 *@Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrderInServiceImplTest {
	@Resource
	private OrderInService orderInServiceImpl;
	private OrderIn orderIn;
	
	@Before
	public void before(){
		orderIn = new OrderIn();
		
		orderIn.setDocu_number("docu_number1");
		orderIn.setFlag(1);
		orderIn.setNumber(90000);
		orderIn.setSource("source1");
		
		WareHouse wareHouse = new WareHouse();
		wareHouse.setId(4);
		wareHouse.setContact("李四");
		wareHouse.setContact_phone("122222");
		wareHouse.setDocu_number("10001");
		wareHouse.setFlag(1);
		wareHouse.setName("name1");
		wareHouse.setTotal_storage(800);
		
		Admin admin = new Admin();
		admin.setIntroduction("123");
		admin.setName("bin");
		admin.setPassword("123344445");
		admin.setUsername("bin");
		admin.setId(5);
		
		Clothes clothes = new Clothes();
		clothes.setId(6);
		clothes.setColor("蓝色");
		clothes.setCommodity_name("中款大衣");
		clothes.setDocuNum("BR1703");
		clothes.setEx_factory_price(450);
		clothes.setFlag(100);
		clothes.setIn_material("布");
		clothes.setOut_material("尼龙");
		clothes.setRetail_price(800);
		clothes.setSize(150);
		
		orderIn.setClothes(clothes);
		orderIn.setWareHouse(wareHouse);
		orderIn.setManager(admin);
	}
	
	@Test
	public void save(){
		String error = orderInServiceImpl.save(orderIn);
		assertThat(error,nullValue());
	}
	
	@Test
	public void update(){
		orderIn.setNumber(1);
		String error = orderInServiceImpl.update(orderIn);
		assertThat(error,nullValue());
	}
	
	@Test
	public void findByDocuNum(){
		orderInServiceImpl.findByDocuNum("docu1");
	}
	
	@Test
	public void delete(){
		orderIn.setOrderId(2);
		orderInServiceImpl.delete(orderIn);
		
	}
	
}
