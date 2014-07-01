/**
 *@Copyright:Copyright (c) 2014
 */
package com.service.impl;

import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import com.dao.ClothesDAO;
import com.dao.OrderInDAO;
import com.dao.OrderInDetailDAO;
import com.dao.StorageDAO;
import com.entity.Clothes;
import com.entity.OrderIn;
import com.entity.OrderInDetail;
import com.entity.Storage;
import com.service.OrderInDetailService;
import com.util.clothes.ClothesServiceMessage;
import com.util.orderIn.OrderInServiceMessage;

/**
 *@Author kklt21cn
 *@Since 2014年6月27日
 *@Version 1.0
 */
@Component
@Transactional
public class OrderInDetailServiceImpl implements OrderInDetailService {
	@Resource
	private OrderInDetailDAO orderInDertailDAOImpl;
	@Resource
	private ClothesDAO clothesDAOImpl;
	@Resource
	private OrderInDAO orderInDAOImpl;
	@Resource
	private StorageDAO storageDAOImpl;
	
	@Override
	public String add(OrderInDetail orderInDetail) {
		//检查Clothes是否存在
		List<Clothes> clothes_result_list = clothesDAOImpl.findClothesByDocuNum(orderInDetail.getClothes().getDocuNum());
		if(clothes_result_list.size() == 0 ){
			return ClothesServiceMessage.no_this_clothes;
		}
		orderInDetail.setClothes(clothes_result_list.get(0));
		//检查入单号是否存在
		OrderIn orderIn_result =  orderInDAOImpl.findById(orderInDetail.getSummary().getOrderId());
		if(orderIn_result == null){
			return OrderInServiceMessage.no_this_orderIn;
		}
		orderInDetail.setSummary(orderIn_result);
		
		
		List<Storage> storage_result_list = storageDAOImpl.findByWareHouseIdAndClothesId(orderIn_result.getWareHouse().getId(),clothes_result_list.get(0).getId());
		if(storage_result_list.size() == 0){
			Storage storage_operated = new Storage();
			storage_operated.setClothes(clothes_result_list.get(0));
			storage_operated.setFlag(1);
			storage_operated.setStorage_Number(orderInDetail.getNumber());
			storage_operated.setWareHouse(orderIn_result.getWareHouse());
			storageDAOImpl.addOrUpdate(storage_operated);
			
		}else{
			int queried_num = storage_result_list.get(0).getStorage_Number();
			storage_result_list.get(0).setStorage_Number(queried_num + orderInDetail.getNumber());
			
			storageDAOImpl.update(storage_result_list.get(0));
		}
		
		
		
		orderInDertailDAOImpl.add(orderInDetail);
		
		/*Log log = new Log();
		log.setAdmin(orderIn.getManager());
		log.setLog(OrderInLogMessage.save_OrderIn_SUCCESS + orderIn.getDocu_number());
		logDAOImpl.save(log);*/
		
		return null;
	}

	@Override
	public String delete(OrderInDetail orderInDetail) {
		List<Clothes> clothes_result_list = clothesDAOImpl.findClothesByDocuNum(orderInDetail.getClothes().getDocuNum());
		if(clothes_result_list.size() == 0 ){
			return ClothesServiceMessage.no_this_clothes;
		}
		orderInDetail.setClothes(clothes_result_list.get(0));
		OrderIn orderIn_result =  orderInDAOImpl.findById(orderInDetail.getSummary().getOrderId());
		if(orderIn_result == null){
			return OrderInServiceMessage.no_this_orderIn;
		}
		orderInDetail.setSummary(orderIn_result);
		orderInDertailDAOImpl.delete(orderInDetail);
		
		
		List<Storage> storage_result_list = storageDAOImpl.findByWareHouseIdAndClothesId(orderIn_result.getWareHouse().getId(),clothes_result_list.get(0).getId());
		Storage storage_queried = storage_result_list.get(0);
		
		
		return null;
	}

	@Override
	public List<OrderInDetail> findOrderDerailByOrderDocuNum(String docuNum) {
		List<OrderIn> orderIn_result_list = orderInDAOImpl.findByDocuNum(docuNum);
		List<OrderInDetail> OrderInDetail_list =orderInDertailDAOImpl.findByOrderInID(orderIn_result_list.get(0).getOrderId());
		return OrderInDetail_list;
	}
	

}
