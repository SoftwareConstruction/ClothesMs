/**
 *@Copyright:Copyright (c) 2014
 */
package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.StorageDAO;
import com.entity.Storage;
import com.util.PageNoUtil;
/**
 *@Author kklt21cn
 *@Since 2014年6月19日
 *@Version 1.0
 */
@Component
public class StorageDAOImpl implements StorageDAO{
	
	@Resource
	private HibernateTemplate hibernateTemplate;

	/* (non-Javadoc)
	 * @see com.dao.StorageDAO#add(com.entity.Storage)
	 */
	@Override
	public void addOrUpdate(Storage storage) {
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(storage);
	}

	/* (non-Javadoc)
	 * @see com.dao.StorageDAO#updata(com.entity.Storage)
	 */
	@Override
	public void update(Storage storage) {
		hibernateTemplate.update(storage);
	}
	
	/* (non-Javadoc)
	 * @see com.dao.StorageDAO#findById(int)
	 */
	@Override
	public Storage findById(int id) {
		Storage storage = hibernateTemplate.get(Storage.class, id);
		return storage;
	}

	

	/* (non-Javadoc)
	 * @see com.dao.StorageDAO#delete(com.entity.Storage)
	 */
	@Override
	public void updateFlag(Storage storage) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(storage);;
	}

	/* (non-Javadoc)
	 * @see com.dao.StorageDAO#findByPaging()
	 */
	@Override
	public List<Storage> findByPaging(final int firstIndex ,final int size) {
		@SuppressWarnings("unchecked")
		List<Storage> result = hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				String hql = "from Storage as a";
				List<?> result = PageNoUtil.getList(session, hql, firstIndex, size);
				return result;
			}
		});
		return result;
	}

	/**
	 * 通过仓库Id和货号Id查询Storage的记录。通过直接执行sql语句得到
	 */
	
	@Override
	public List<Integer> findIdByWareHouseIdAndClothesId(final int wareHouseId,
			final int clothesId) {
		@SuppressWarnings("unchecked")
		List<Integer> result = hibernateTemplate.execute(new HibernateCallback(){
		@Override
		public Object doInHibernate(Session session)
				throws HibernateException {
				String sql = "select Id from t_storage where warehouse_id=? and clothes_id=?";
				SQLQuery query = session.createSQLQuery(sql);
				query.setInteger(0, wareHouseId);
				query.setInteger(1, clothesId);
				List<Integer> result = query.list();
				//List<Storage> result = query.list();
				return result;
			}
		});
		return result;
	}
	
	@Override
	public List<Integer> findByWareHouseIdAndClothesId(final int wareHouseId,
			final int clothesId) {
		@SuppressWarnings("unchecked")
		List<Integer> result = hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				String sql = "select storage_number from t_storage where warehouse_id=? and clothes_id=?";
				SQLQuery query = session.createSQLQuery(sql);
				query.setInteger(0, wareHouseId);
				query.setInteger(1, clothesId);
				List<Integer> result = query.list();
				//List<Storage> result = query.list();
				return result;
			}
		});
		return result;
	}
	
	
}
