/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.OrderOutDAO;
import com.entity.Admin;
import com.entity.Clothes;
import com.entity.OrderOut;
import com.entity.WareHouse;

/**
 *@Author kklt21cn
 *@Since 2014年6月25日
 *@Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class OrderOutDAOImplTest {
	@Resource
	private OrderOutDAO orderOutDAOImpl ;
	private OrderOut orderOut;
	
	@Before
	public void before(){
		orderOut = new OrderOut();
		
		orderOut.setDocu_number("docu2");
		orderOut.setFlag(1);
		orderOut.setSource("以纯制衣厂");
		orderOut.setNumber(999999);
		
		Admin manager = new Admin();
		manager.setId(1);
		manager.setIntroduction("123");
		manager.setName("bin");
		manager.setPassword("123344445");
		manager.setUsername("bin");
		
		WareHouse wareHouse = new WareHouse();
		wareHouse.setId(1);
		wareHouse.setContact("李四");
		wareHouse.setContact_phone("122222");
		wareHouse.setDocu_number("10001");
		wareHouse.setFlag(1);
		wareHouse.setName("高邮仓库");
		wareHouse.setTotal_storage(800);

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
		
		orderOut.setClothes(clothes);
		orderOut.setManager(manager);
		orderOut.setWareHouse(wareHouse);
	}
	
	@Test
	public void add(){
		orderOutDAOImpl.add(orderOut);
	}
	@Test
	public void updateFlag(){
		orderOut.setOrderId(1);
		orderOutDAOImpl.updateFlag(orderOut);
	}
	
	@Test
	public void update(){
		orderOut.setOrderId(1);
		orderOut.setSource("1212");
		orderOutDAOImpl.update(orderOut);
	}
	
	@Test
	public void findById(){
		List<OrderOut> result = orderOutDAOImpl.findById(1);
		assertThat(result.size(),is(1));
	}
	
	@Test
	public void findAllByPaging(){
		List<OrderOut> result = orderOutDAOImpl.findAllByPaging(3,2);
		assertThat(result.size(),is(2));
	}
	
	@Test
	public void findByDocuNum(){
		List<OrderOut> result = orderOutDAOImpl.findByDocuNum("asd");
		assertThat(result.size(),is(1));
	}
	
	@Test
	public void getAccount(){
		int account = orderOutDAOImpl.getAccount();
		assertThat(account ,is(9));
	}
}
