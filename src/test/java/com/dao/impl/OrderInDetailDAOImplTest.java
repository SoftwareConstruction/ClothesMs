/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao.impl;

import java.util.List;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.OrderInDetailDAO;
import com.entity.Clothes;
import com.entity.OrderIn;
import com.entity.OrderInDetail;

/**
 *@Author kklt21cn
 *@Since 2014年6月27日
 *@Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class OrderInDetailDAOImplTest {
	@Resource
	private OrderInDetailDAO orderInDetailDAOImpl ;
	private OrderInDetail orderInDetail;
	
	@Before
	public void before(){
		orderInDetail = new OrderInDetail();
		orderInDetail.setNumber(1000);
		Clothes clothes = new Clothes();
		clothes.setId(2);
		
		OrderIn orderIn = new OrderIn();
		orderIn.setOrderId(1);
		
		orderInDetail.setClothes(clothes);
		orderInDetail.setSummary(orderIn);
	}
	
	@Test
	public void add(){
		orderInDetailDAOImpl.add(orderInDetail);
	}
	
	@Test
	public void findByClothesIdAndOrderInId(){
		List<OrderInDetail> orderInDeatil = (List<OrderInDetail>) orderInDetailDAOImpl.findByClothesIdAndOrderInId(2, 1);
		assertThat(orderInDeatil.get(0).getId(),is(1));
	}
	
	@Test
	public void findByOrderInId(){
		List<OrderInDetail> result = orderInDetailDAOImpl.findByOrderInID(1);
		assertThat(result.size(),is(1));
	}
	
	@Test
	public void delete(){
		orderInDetail.setId(1);
		orderInDetailDAOImpl.delete(orderInDetail);
	}
}
