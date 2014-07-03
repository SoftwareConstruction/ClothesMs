/**
 *@Copyright:Copyright (c) 2014
 */
package com.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.dao.AdminDAO;
import com.dao.OrderOutDAO;
import com.dao.WareHouseDAO;
import com.entity.Admin;
import com.entity.Clothes;
import com.entity.OrderOut;
import com.entity.Storage;
import com.entity.WareHouse;
import com.service.OrderOutService;
import com.util.OrderOutServiceMessage;
import com.util.clothes.ClothesServiceMessage;
import com.util.storage.StorageServiceMessage;
import com.util.wareHouse.WareHouseServiceMessage;

/**
 *@Author kklt21cn
 *@Since 2014年6月26日
 *@Version 1.0
 */
@Component
@Transactional
public class OrderOutServiceImpl implements OrderOutService {
	@Resource
	private OrderOutDAO orderOutDAOImpl;
	@Resource
	private WareHouseDAO wareHouseDAOImpl;
	
	
	@Override
	public String save(OrderOut orderOut) {
		List<WareHouse> wareHouse_list = wareHouseDAOImpl.findByName(orderOut.getWareHouse().getName());
		if(wareHouse_list.size()==0){
			return WareHouseServiceMessage.no_this_WareHouse;
		}
		//生成入单的编号，并set进orderIn里，编号为操作人员的账号+仓库的编号+操作的日期
		String docuNum = orderOut.getManager().getUsername() + wareHouse_list.get(0).getDocu_number()+orderOut.getOut_time().toString();
		orderOut.setDocu_number(docuNum);
		
		orderOut.setWareHouse(wareHouse_list.get(0));
		orderOutDAOImpl.add(orderOut);
		return null;
	}

	@Override
	public String delete(OrderOut orderOut) {
		List<OrderOut> orderOut_list = orderOutDAOImpl.findById(orderOut.getOrderId());
		if(orderOut_list.size() == 0){
			return OrderOutServiceMessage.no_this_orderOut;
		}
		orderOut_list.get(0).setFlag(0);
		orderOutDAOImpl.update(orderOut_list.get(0));
		return null;
	}

	@Override
	public String update(OrderOut orderOut) {
		List<WareHouse> wareHouse_list = wareHouseDAOImpl.findByName(orderOut.getWareHouse().getName());
		if(wareHouse_list.size()==0){
			return WareHouseServiceMessage.no_this_WareHouse;
		}
		orderOut.setWareHouse(wareHouse_list.get(0));
		orderOutDAOImpl.update(orderOut);
		return null;
	}


	@Override
	public List<OrderOut> findById(int id) {
		List<OrderOut> result = orderOutDAOImpl.findById(id);
		return null;
	}

	@Override
	public List<OrderOut> findByAllPaging(int firstIndex,int size) {
		List<OrderOut> result = orderOutDAOImpl.findAllByPaging(firstIndex, size);
		return result;
	}

	@Override
	public int getAccount() {
		int result = orderOutDAOImpl.getAccount();
		return result;
	}

}
