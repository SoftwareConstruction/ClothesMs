/**
 *@Copyright:Copyright (c) 2014
 */
package com.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.dao.ClothesDAO;
import com.dao.OrderOutDAO;
import com.dao.OrderOutDetailDAO;
import com.dao.StorageDAO;
import com.entity.Clothes;
import com.entity.OrderOut;
import com.entity.OrderOutDetail;
import com.entity.Storage;
import com.service.OrderOutDetailService;
import com.util.OrderOutServiceMessage;
import com.util.clothes.ClothesServiceMessage;
import com.util.storage.StorageServiceMessage;

/**
 *@Author kklt21cn
 *@Since 2014年6月28日
 *@Version 1.0
 */
@Transactional
@Component
public class OrderOutDetailServiceImpl implements OrderOutDetailService {
	@Resource
	private OrderOutDetailDAO orderOutDetailDAOImpl;
	@Resource
	private StorageDAO storageDAOImpl;
	@Resource
	private OrderOutDAO orderOutDAOImpl;
	@Resource
	private ClothesDAO clothesDAOImpl;
	@Override
	public String save(OrderOutDetail orderOutDetail) {
		
		String clothes_docuNum = orderOutDetail.getClothes().getDocuNum();
		List<Clothes> clothes_result_list = clothesDAOImpl.findClothesByDocuNum(clothes_docuNum);
		if(clothes_result_list.size() == 0){
			return ClothesServiceMessage.no_this_clothes;
		}
		orderOutDetail.setClothes(clothes_result_list.get(0));
		List<OrderOut> orderOut_result_list = orderOutDAOImpl.findById(orderOutDetail.getSummary().getOrderId());
		if(orderOut_result_list.size() == 0){
			return OrderOutServiceMessage.no_this_orderOut;
		}
		orderOutDetail.setSummary(orderOut_result_list.get(0));
		List<Storage> storage_result_list = storageDAOImpl.findByWareHouseIdAndClothesId(orderOut_result_list.get(0).getWareHouse().getId(),clothes_result_list.get(0).getId());
		Storage storage_result = storage_result_list.get(0);
		int storage_num = storage_result.getStorage_Number();
		if(storage_num<0){
			return StorageServiceMessage.storage_not_enough;
		}
		storage_result.setStorage_Number(storage_num - orderOutDetail.getNumber());
		storageDAOImpl.update(storage_result);
		
		orderOutDetailDAOImpl.add(orderOutDetail);
		return null;
	}

	@Override
	public String delete(OrderOutDetail orderOutDetail) {
		List<OrderOutDetail> orderOutDetail_result_list =  orderOutDetailDAOImpl.getById(orderOutDetail.getId());
		String clothes_docuNum = orderOutDetail.getClothes().getDocuNum();
		List<Clothes> clothes_result_list = clothesDAOImpl.findClothesByDocuNum(clothes_docuNum);
		List<OrderOut> orderOut_result_list = orderOutDAOImpl.findById(orderOutDetail.getSummary().getOrderId());
		List<Storage> storage_result_list = storageDAOImpl.findByWareHouseIdAndClothesId(orderOut_result_list.get(0).getWareHouse().getId(),clothes_result_list.get(0).getId());
		Storage storage_result = storage_result_list.get(0);
		int storage_num = storage_result.getStorage_Number();
		storage_result.setStorage_Number(storage_num + orderOutDetail.getNumber());
		storageDAOImpl.update(storage_result);
		
		orderOutDetailDAOImpl.delete(orderOutDetail_result_list.get(0));
		return null;
	}

	@Override
	public String update(OrderOutDetail orderOutDetail) {
		orderOutDetailDAOImpl.update(orderOutDetail);
		return null;
	}

	@Override
	public List<OrderOutDetail> findByOrderId(int orderOutid) {
		List<OrderOutDetail> result = orderOutDetailDAOImpl.findByOrderOutID(orderOutid);
		return result;
	}

}
