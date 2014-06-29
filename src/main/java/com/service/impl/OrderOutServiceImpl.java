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
		/*List<WareHouse> wareHouse_list = wareHouseDAOImpl.findByName(orderOut.getWareHouse().getName());
		if(wareHouse_list.size()==0){
			return WareHouseServiceMessage.no_this_WareHouse;
		}
		orderOut.setWareHouse(wareHouse_list.get(0));
		List<Clothes> clothes_list = clothesDAOImpl.findClothesByDocuNum(orderOut.getClothes().getDocuNum());
		if(clothes_list.size()==0){
			return ClothesServiceMessage.no_this_clothes;
		}
		orderOut.setClothes(clothes_list.get(0));
		List<Integer> storage_id_list = storageDAOImpl.findIdByWareHouseIdAndClothesId(wareHouse_list.get(0).getId(),clothes_list.get(0).getId());
		if(storage_id_list.size()==0){
			return StorageServiceMessage.no_this_storage;
		}
		
		Storage storage_queried = storageDAOImpl.findById(storage_id_list.get(0));
		int accuont_queried = storage_queried.getStorage_Number();
		if(accuont_queried<orderOut.getNumber()){
			return StorageServiceMessage.storage_not_enough; 
		}
		storage_queried.setStorage_Number(accuont_queried-orderOut.getNumber());
		storageDAOImpl.update(storage_queried);
		
		List<OrderOut> orderOut_queried_list = orderOutDAOImpl.findByDocuNum(orderOut.getDocu_number());
		OrderOut orderOut_queried = orderOut_queried_list.get(0);
		
		orderOut_queried.setNumber(orderOut.getNumber());
		orderOut_queried.setSend(orderOut.getSend());
		
		orderOutDAOImpl.update(orderOut_queried);*/
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
		return null;
	}

	@Override
	public int getAccount() {
		int result = orderOutDAOImpl.getAccount();
		return result;
	}

}
