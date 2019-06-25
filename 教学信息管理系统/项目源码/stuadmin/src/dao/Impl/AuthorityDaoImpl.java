package dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.AuthorityDao;
import domain.Authority;

@Transactional
public class AuthorityDaoImpl extends HibernateDaoSupport implements AuthorityDao{

	@Override
	public List<Authority> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows) {
		// TODO Auto-generated method stub
		detachedCriteria.setProjection(null);
		return (List<Authority>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, rows);
	}

	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list  = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}


	public void save(Authority authority) {
		// TODO Auto-generated method stub
		System.out.println("DAO中的save方法执行了...");
		System.out.println("action中获得的authority角色="+authority.getRole());
		this.getHibernateTemplate().save(authority);
	}

	@Override
	public List<Authority> findById(String[] arr) {
		List<Authority> list = new ArrayList<Authority>();
		List<Authority> realList = new ArrayList<Authority>();
		// TODO Auto-generated method stub
		System.out.println(arr.length);
		for(int i = 0 ; i < arr.length ; i++){
			int id = Integer.parseInt(arr[i]);
			String hql = "from Authority where author_Id ="+id;
			list = (List<Authority>) this.getHibernateTemplate().find(hql);
			if(list.size() > 0){
				realList.add(list.get(0));
			}
		}
		return realList;
	}

	@Override
	public void delete(List<Authority> list) {
		// TODO Auto-generated method stub
		for (Authority authority : list) {
			this.getHibernateTemplate().delete(authority);
		}
	}

	@Override
	public Authority findBySelectId(String id) {
		// TODO Auto-generated method stub
		int intid=Integer.parseInt(id);
		String sql="from Authority where author_Id="+intid;
		List<Authority> list = (List<Authority>) this.getHibernateTemplate().find(sql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void update(Authority authority) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(authority);
	}

}
