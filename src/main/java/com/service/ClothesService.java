package com.service;

import java.util.List;

import com.entity.Admin;
import com.entity.Clothes;

public interface ClothesService {
	public String save(Clothes clothes,Admin operator);
	public String update(Clothes clothes,Admin operator);
	/**
	 * @param docuNum 为货号的编号
	 * @param operator
	 * @return 错误的信息，为空即没有
	 * @Description
	 */
	public String delete(String docuNum ,Admin operator);
	public List<Clothes> findAllByPaging(int firstIndex,int size);
	public Clothes findClothesByDocuNum(String docuNum);
	public int getAccount();
}
