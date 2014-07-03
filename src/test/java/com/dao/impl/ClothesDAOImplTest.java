package com.dao.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dao.ClothesDAO;
import com.entity.Admin;
import com.entity.Clothes;

@SuppressWarnings("unchecked")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class ClothesDAOImplTest {
	@Resource
	private ClothesDAO clothesDAOImpl;
	
	private Clothes clothes ;
	private Admin admin;
	@Before
	public void before(){
		clothes = new Clothes();
		clothes.setColor("蓝色");
		clothes.setCommodity_name("中款大衣");
		clothes.setDocuNum("BR1703");
		clothes.setEx_factory_price(450);
		clothes.setFlag(100);
		clothes.setIn_material("布");
		clothes.setOut_material("尼龙");
		clothes.setRetail_price(800);
		clothes.setSize(150);
		
		admin = new Admin();
		admin.setId(1);
		
	}
	@Test
	public void save(){
		clothes.setOperator(admin);
		clothesDAOImpl.save(clothes);
	}
	
	@Test
	public void update(){
		clothes.setId(2);
		clothes.setCommodity_name("中款大衣");
		clothes.setDocuNum("docu2");
		clothes.setEx_factory_price(450);
		clothes.setFlag(100);
		clothes.setIn_material("布");
		clothes.setOut_material("尼龙");
		clothes.setRetail_price(800);
		clothes.setSize(150);
		clothes.setColor("深蓝色");
		
		clothes.setOperator(admin);
		clothesDAOImpl.update(clothes);
		List<Clothes> result = clothesDAOImpl.findClothesByDocuNum("BR1703");
		
	}
	
	@Test
	public void findClothesByDocuNum(){
		List<Clothes> result = clothesDAOImpl.findClothesByDocuNum("docu2");
		assertThat(result.size(),is(1));
	}
	
	@Test
	public void findClothesPaging(){
		List<Clothes> result = clothesDAOImpl.findAllByPaging(0, 10);
		assertThat(result.size(),is(10));
	}
	
	@Test
	public void updataFlag(){
		clothes.setId(2);
		clothes.setFlag(0);
		clothes.setOperator(admin);
		clothesDAOImpl.updateFlag(clothes);
	}
	
	@Test
	public void getAccount(){
		int result = clothesDAOImpl.getAccount();
		assertThat(result,is(18));
	}
}
