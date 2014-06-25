/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao;

import java.util.List;

import com.entity.Storage;

/**
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
public interface StorageDAO {
	public void addOrUpdate(Storage storage);
	public void update(Storage storage);
	public void updateFlag(Storage storage);
	public List<Storage> findByPaging(final int firstIndex ,final int size);
	public List<Integer> findByWareHouseIdAndClothesId(int wareHouseId ,int clothesId);
	public List<Integer> findIdByWareHouseIdAndClothesId(int wareHouseId ,int clothesId);
	public Storage findById(int id);
}

