/**
 *@Copyright:Copyright (c) 2014
 */
package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dao.OrderInDAO;
import com.dao.StorageDAO;
import com.dao.WareHouseDAO;
import com.entity.OrderIn;
import com.entity.WareHouse;
import com.service.OrderInService;
import com.util.wareHouse.WareHouseServiceMessage;

/**
 *@Author kklt21cn
 *@Since 2014年6月20日
 *@Version 1.0
 */
@Component
public class OrderInServiceImpl implements OrderInService{
	@Resource
	private OrderInDAO orderInDAOImpl;
	@Resource
	private WareHouseDAO wareHouseDAOImpl;
	@Resource
	private StorageDAO StorageDAOImpl;
	
	
	@Override
	public String save(OrderIn orderIn) {
		List<WareHouse> result = wareHouseDAOImpl.findByName(orderIn.getWareHouse().getName());
		if(result.size() == 0){
			return WareHouseServiceMessage.no_this_WareHouse;
		}else{
			orderIn.setWareHouse(result.get(0));
			
		}
		
		return null;
	}

	@Override
	public String update(OrderIn orderIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String delete(OrderIn orderIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderIn findById(OrderIn orderIn) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrderIn> findAllByPaging(int first, int size) {
		// TODO Auto-generated method stub
		return null;
	}

}
