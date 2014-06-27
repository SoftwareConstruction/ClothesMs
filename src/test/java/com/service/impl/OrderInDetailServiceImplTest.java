/**
 *@Copyright:Copyright (c) 2014
 */
package com.service.impl;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;

/**
 *@Author kklt21cn
 *@Since 2014年6月27日
 *@Version 1.0
 */import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.Clothes;
import com.entity.OrderIn;
import com.entity.OrderInDetail;
import com.service.OrderInDetailService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrderInDetailServiceImplTest {
	@Resource
	private OrderInDetailService orderInDetailServiceImpl;
	OrderInDetail orderInDetail = null;
	@Before
	public void before(){
		orderInDetail = new OrderInDetail();
		orderInDetail.setNumber(1000);
		
		OrderIn summary = new OrderIn();
		summary.setOrderId(1);
		
		Clothes clothes = new Clothes();
		clothes.setDocuNum("docu8");
		orderInDetail.setClothes(clothes);
		orderInDetail.setSummary(summary);
	}
	
	@Test
	public void save(){
		String result = orderInDetailServiceImpl.add(orderInDetail);
		assertThat(result,nullValue());
	}
	
	@Test
	public void  delete(){
		orderInDetail.setId(4);
		String result = orderInDetailServiceImpl.delete(orderInDetail);
		assertThat(result,nullValue());
	}
	
	@Test
	public void findByOrderOrderInDocuNum(){
		List<OrderInDetail> result = orderInDetailServiceImpl.findOrderDerailByOrderDocuNum("docu");
		assertThat(result.size(),is(1));
	}
}
