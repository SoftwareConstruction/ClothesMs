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
	private void before(){
		
	}
	
	@Test
	public void add(){
		String docuNum ="";
		String remark ="";
		String wareHouse_name = "一号仓";
		String source ="泰国";
		String dateStr ="2011-1-1";
		
		orderIn.setDateStr(dateStr);
		orderIn.setDocuNum(docuNum);
		orderIn.setRemark(remark);
		orderIn.setSource(source);
		
		orderIn.add();
	}
}
