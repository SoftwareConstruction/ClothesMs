/**
 *@Copyright:Copyright (c) 2014
 */
package com.action;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *@Author kklt21cn
 *@Since 2014年7月1日
 *@Version 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class OrderInActionTest {
	@Resource
	private OrderInAction orderIn;
	
	@Before
	public void before(){
		
	}
	
	@Test
	public void add(){
		String remark ="没有备注";
		String wareHouse_name = "一号仓";
		String source ="泰国";
		String dateStr ="2011-1-1";
		
		orderIn.setWareHouse_name(wareHouse_name);
		orderIn.setDateStr(dateStr);
		orderIn.setRemark(remark);
		orderIn.setSource(source);
		
		
		
		String result = orderIn.add();
	}
}
