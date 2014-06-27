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
import com.entity.Clothes;
import com.entity.Log;
import com.entity.OrderIn;
import com.entity.OrderInDetail;
import com.service.OrderInDetailService;
import com.util.OrderIn.OrderInLogMessage;
import com.util.OrderIn.OrderInServiceMessage;
import com.util.clothes.ClothesServiceMessage;

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
	
	@Override
	public String add(OrderInDetail orderInDetail) {
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
		
		return null;
	}

	@Override
	public List<OrderInDetail> findOrderDerailByOrderDocuNum(String docuNum) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
