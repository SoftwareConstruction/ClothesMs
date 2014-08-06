package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.WareHouseDAO;
import com.entity.WareHouse;
import com.util.GetAccountWithHibernateCallback;
import com.util.PageNoUtil;
@SuppressWarnings("unchecked")
@Component
public class WareHouseDAOImpl implements WareHouseDAO{
	@Resource
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public void save(WareHouse wareHouse) {
		hibernateTemplate.save(wareHouse);
	}

	@Override
	public List findByDocu_number(String docu_number){
		List<WareHouse> list = (List<WareHouse>) hibernateTemplate.find("from WareHouse as wh where wh.docu_number=?",docu_number);
		return list;
	}

	@Override
	public void updateFlag(WareHouse warreHouse) {
		hibernateTemplate.update(warreHouse);
	}

	@Override
	public void update(WareHouse wareHouse) {
		hibernateTemplate.update(wareHouse);
	}

	@Override
	public List<WareHouse> findAllByPaging(final int firstIndex,final int size) {
		List<WareHouse> list = hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				String hql = "from WareHouse as a where a.flag=1 ";
				List<?> list = PageNoUtil.getList(session, hql, firstIndex, size);
				return list;
			}
		});
		return list;
	}

	
	@Override
	public List<WareHouse> findByName(String name) {
		List<WareHouse> result = (List<WareHouse>) hibernateTemplate.find("from WareHouse as wh where wh.name=?",name);
		return result;
	}

	@Override
	public int getAccount() {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		int result = (int) new GetAccountWithHibernateCallback("WareHouse").doInHibernate(session);
		return result;
	}

	@Override
	public List<WareHouse> findAllName() {
		List<WareHouse> result = (List<WareHouse>) hibernateTemplate.find("from WareHouse as w");
		return result;
	}
	
	
	
}
