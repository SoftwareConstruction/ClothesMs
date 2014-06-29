/**
 *@Copyright:Copyright (c) 2014
 */
package com.service.impl;

import javax.annotation.Resource;

import com.dao.StorageDAO;
import com.entity.Storage;
import com.service.StorageService;

/**
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0W
 */
public class StorageServiceImpl implements StorageService {
	@Resource
	private StorageDAO storageDAOImpl;
	
	@Override
	public String save(Storage storage) {
		storageDAOImpl.addOrUpdate(storage);
		return null;
	}

	@Override
	public Storage findById() {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public String delete(Storage storage) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public String update(Storage storage) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
