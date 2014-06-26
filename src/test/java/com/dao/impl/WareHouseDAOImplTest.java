package com.dao.impl;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.entity.WareHouse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class WareHouseDAOImplTest {
	@Resource
	private WareHouseDAOImpl wareHouseDAOImpl;
	
	@Test
	public void save(){
		WareHouse wareHouse = new WareHouse();
		wareHouse.setContact("李四");
		wareHouse.setContact_phone("122222");
		wareHouse.setDocu_number("10001");
		wareHouse.setFlag(1);
		wareHouse.setName("高邮仓库");
		wareHouse.setTotal_storage(800);
		wareHouseDAOImpl.save(wareHouse);
	}
	
	@Test
	public void findByDocu_number(){
		String docu_number = "10000";
		List result  = null;
		try{
			result = wareHouseDAOImpl.findByDocu_number(docu_number);
		}catch(Exception e){
			e.printStackTrace();
		}
		assertThat(result.size(),is(1));
	}
	
	@Test
	public void updateFlag(){
		WareHouse wareHouse = new WareHouse();
		wareHouse.setId(1);
		wareHouse.setContact("李四");
		wareHouse.setContact_phone("122222");
		wareHouse.setDocu_number("10000");
		wareHouse.setFlag(0);
		wareHouse.setName("高邮仓库");
		wareHouse.setTotal_storage(800);
		wareHouseDAOImpl.updateFlag(wareHouse);
		List<WareHouse> result = wareHouseDAOImpl.findByDocu_number(wareHouse.getDocu_number());
		assertThat(result.get(0).getFlag(), is(0));
	}
	
	@Test
	public void update(){
		WareHouse wareHouse = new WareHouse();
		wareHouse.setId(1);
		wareHouse.setContact("李四");
		wareHouse.setContact_phone("122222");
		wareHouse.setDocu_number("10000");
		wareHouse.setFlag(0);
		wareHouse.setName("高邮仓库");
		wareHouse.setTotal_storage(800);
		wareHouseDAOImpl.update(wareHouse);
		List<WareHouse> result = wareHouseDAOImpl.findByDocu_number(wareHouse.getDocu_number());
		assertThat(result.get(0).getContact(),equalTo("李四"));
	}
	
	@Test
	public void findAllByPaging(){
		List<WareHouse> result = wareHouseDAOImpl.findAllByPaging(0, 10);
		assertThat(result.size(), is(10));
	}
	
	@Test
	public void findByName(){
		String name = "name1";
		List<WareHouse> result = wareHouseDAOImpl.findByName(name);
		assertThat(result.size(),is(1));
	}
	
	@Test
	public void getAccount(){
		int result = wareHouseDAOImpl.getAccount();
		assertThat(result,is(12));
	}
}
