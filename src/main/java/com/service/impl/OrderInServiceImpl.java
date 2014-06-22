/**
 *@Copyright:Copyright (c) 2014
 */
package com.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.dao.ClothesDAO;
import com.dao.LogDAO;
import com.dao.OrderInDAO;
import com.dao.StorageDAO;
import com.dao.WareHouseDAO;
import com.entity.Clothes;
import com.entity.Log;
import com.entity.OrderIn;
import com.entity.Storage;
import com.entity.WareHouse;
import com.service.OrderInService;
import com.util.OrderIn.OrderInLogMessage;
import com.util.OrderIn.OrderInServiceMessage;
import com.util.clothes.ClothesServiceMessage;
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
	private StorageDAO storageDAOImpl;
	@Resource
	private ClothesDAO clothesDAOImpl;
	@Resource
	private LogDAO logDAOImpl;
	
	@Override
	public String save(OrderIn orderIn) {
		List<WareHouse> wareHouse_result = wareHouseDAOImpl.findByName(orderIn.getWareHouse().getName());
		List<Storage> storage_result = null;
		//检查是否存在这个仓库
		if(wareHouse_result.size() == 0){
			return WareHouseServiceMessage.no_this_WareHouse;
		}else{
			orderIn.setWareHouse(wareHouse_result.get(0));
			List<Clothes> clothes_result = clothesDAOImpl.findClothesByDocuNum(orderIn.getDocu_number());
			//检查是否存在这个货号
			if(clothes_result.size() == 0){
				return ClothesServiceMessage.no_this_clothes;
			}else{
				storage_result = storageDAOImpl.findByWareHouseIdAndClothesId(wareHouse_result.get(0).getId(), clothes_result.get(0).getId());
				//当存储表中没有这条记录是直接存进去
				if(storage_result.size() == 0){
					Storage storage = new Storage();
					storage.setClothes(clothes_result.get(0));
					storage.setWareHouse(wareHouse_result.get(0));
					storageDAOImpl.addOrUpdate(storage);
					
					Log log = new Log();
					log.setAdmin(orderIn.getManager());
					log.setLog(OrderInLogMessage.save_OrderIn_SUCCESS + orderIn.getDocu_number());
					logDAOImpl.save(log);
					
					return null;
				}else{
					//将查询到的storage记录中的当前存储量修改为最新数量
					Storage storage_queried = storage_result.get(0);
					int pre_num = storage_queried.getStorage_Number();
					storage_queried.setStorage_Number(pre_num+orderIn.getNumber());
					storageDAOImpl.update(storage_queried);
					
					Log log = new Log();
					log.setAdmin(orderIn.getManager());
					log.setLog(OrderInLogMessage.save_OrderIn_SUCCESS + orderIn.getDocu_number());
					logDAOImpl.save(log);
					
					return null;
				}
			}
		}
	}

	@Override
	public String update(OrderIn orderIn) {
		List<WareHouse> wareHouse_result = wareHouseDAOImpl.findByName(orderIn.getWareHouse().getName());
		List<Storage> storage_result = null;
		//检查是否存在这个仓库
		if(wareHouse_result.size() == 0){
			return WareHouseServiceMessage.no_this_WareHouse;
		}else{
			orderIn.setWareHouse(wareHouse_result.get(0));
			List<Clothes> clothes_result = clothesDAOImpl.findClothesByDocuNum(orderIn.getDocu_number());
			//检查是否存在这个货号
			if(clothes_result.size() == 0){
				return ClothesServiceMessage.no_this_clothes;
			}else{
				storage_result = storageDAOImpl.findByWareHouseIdAndClothesId(wareHouse_result.get(0).getId(), clothes_result.get(0).getId());
				//当存储表中没有这条记录是直接存进去
				if(storage_result.size() == 0){
					return OrderInServiceMessage.no_this_orderIn;
				}else{
					orderInDAOImpl.update(orderIn);
				}
			}
		}
		return null;
	}

	@Override
	public String delete(OrderIn orderIn) {
		return null;
	}

	@Override
	public OrderIn findById(OrderIn orderIn) {
		OrderIn result = orderInDAOImpl.findById(orderIn.getOrderId());
		return result;
	}

	@Override
	public List<OrderIn> findAllByPaging(int first, int size) {
		List<OrderIn> result = orderInDAOImpl.findAllByPaging(first, size);
		return result;
	}
	
	@Override
	public OrderIn findByDocuNum(String docuNum) {
		List<OrderIn> result = orderInDAOImpl.findByDocuNum(docuNum);
		if(result.size()==0){
			return null;
		}else{
			return result.get(0);
		}
	}
}
