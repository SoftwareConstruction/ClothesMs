package com.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.dao.AdminDAO;
import com.entity.Admin;
import com.util.GetAccountWithHibernateCallback;
import com.util.PageNoUtil;

@SuppressWarnings("unchecked")
@Component("adminDAOImpl")
public class AdminDAOImpl implements AdminDAO{
	
	@Resource
	private HibernateTemplate hibernateTemplate;
	public List<Admin> loadByUsernameAndPassword(String username,String password){
		List<Admin> result = (List<Admin>) hibernateTemplate.find("from Admin as a where a.username=? and a.password =? and a.flag=1",username,password);
		return result;
	}

	@Override
	public void save(Admin admin) {
		hibernateTemplate.save(admin);
	}
	
	@Override
	public void updateFlag(Admin admin){
		hibernateTemplate.update(admin);
	}

	@Override
	public List<Admin> loadByUsername(String username) {
		List<Admin> result = (List<Admin>) hibernateTemplate.find("from Admin as a where a.username = ?", username );
		return result;
	}
	
	@Override
	public void update(Admin admin){
		hibernateTemplate.update(admin);
	}

	@Override
	public List<Admin> findAllByPaging(final int firstIndex ,final int size) {
		List<Admin> result = hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				String hql = "from Admin as a where a.flag=1";
				List<?> result = PageNoUtil.getList(session, hql, firstIndex, size);
				return result;
			}
		});
		return result;
	}

	@Override
	public Admin getAdminById(int id) {
		Admin result = hibernateTemplate.get(Admin.class, id);
		return result;
	}

	@Override
	public int getAccount() {
		
		/*int result = hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				String sql = "select count(*) from Admin where flag=1";
				long count =0;
				try{
					count= ((Long) session.createQuery(sql).iterate().next()).intValue();
				}catch(Exception e){
					e.printStackTrace();
				}
				int result = (int)count;
				return result;
			}
		});*/
		
		Session session=hibernateTemplate.getSessionFactory().getCurrentSession();
		int result = (int) new GetAccountWithHibernateCallback("Admin").doInHibernate(session);
		return result;
	}

	/* (non-Javadoc)
	 * @see com.dao.AdminDAO#findByFuzzyUsername(java.lang.String, int, int)
	 */
	@Override
	public List<Admin> findByFuzzyUsername(final String usernmae,final int firstIndex, final int size) {
		List<Admin> result = hibernateTemplate.execute(new HibernateCallback(){
			@Override
			public Object doInHibernate(Session session)
					throws HibernateException {
				String hql = "from Admin as a where a.username like '%"+ usernmae +"%'";
				List<?> result = PageNoUtil.getList(session, hql, firstIndex, size);
				return result;
			}
		});
		return result;
	}
	
	
	
}
