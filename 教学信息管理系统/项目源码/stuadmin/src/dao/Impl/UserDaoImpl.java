package dao.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.regexp.internal.recompile;

import dao.UserDao;
import domain.PersonCounts;
import domain.User;

@Transactional
public class UserDaoImpl extends HibernateDaoSupport implements UserDao{
	
	@Override
	public List<User> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows) {
		// TODO Auto-generated method stub
		System.out.println("Userdaoimpl中的方法执行了...");
		detachedCriteria.setProjection(null);
		return  (List<User>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, rows);
	
		
		 
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

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		System.out.println("DAO中的save方法执行了...");
		System.out.println("action中获得的User姓名="+user.getUser_name());		
		this.getHibernateTemplate().save(user);
		/*String hql="update PersonCounts set User_counts=(select count(*) from User)";
		this.getHibernateTemplate().update(hql);*/
	}

	@Override
	public List<User> findById(String[] arr) {
		List<User> list=new ArrayList<User>();
	   ArrayList<User> realList= new ArrayList<User>();
	   System.out.println("Userdaoimpl的id数组长度"+arr.length);
		for (int i = 0; i < arr.length; i++) {
			int id = Integer.parseInt(arr[i]);
			String hql="from User where id="+id;
		 list = (List<User>) this.getHibernateTemplate().find(hql);
		 if(list.size() > 0){
				realList.add(list.get(0));
			}
		}
		
		return realList;
	}

	@Override
	public void delete(List<User> list) {
		// TODO Auto-generated method stub
		for(User user:list){
			this.getHibernateTemplate().delete(user);
			
		}
	}

	@Override
	public User findBySelectId(String id) {
		int intid=Integer.parseInt(id);
		String sql="from User where id="+intid;
		List<User> list = (List<User>) this.getHibernateTemplate().find(sql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(user);;
	}

	@Override
	public int findCounts(User user) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);		
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list  = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0){
		return list.get(0).intValue();
		
		}
		return 0;
	}

	@Override
	public int findCounts(DetachedCriteria detachedCriteria) {
		List<Long> list  = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0){
		return list.get(0).intValue();
		
		}
		return 0;
	}

	@Override
	public int findUserCounts() {
		// TODO Auto-generated method stub
		/*System.out.println("User=====findUserCounts方法执行了");
		List<Long> list  = (List<Long>) this.getHibernateTemplate().find("select count(*) from User");
	
		
		if(list.size()>0){
		return list.get(0).intValue();
		
		}
		return 0;*/
		
		ArrayList<User> realList = new ArrayList<User>();
		//String hql = "select * from PersonCounts";

		List<User> list = (List<User>) this.getHibernateTemplate().find("from User");

		if (list.size() > 0) {
			realList.add(list.get(0));

		}
		int flist=realList.size();
		System.out.println(" --------------flist="+flist);
		return flist;
		
		
	}

	@Override
	public Boolean findByUser(User user) {
		List<User> findByExample = this.getHibernateTemplate().findByExample(user);		
		System.out.println("findByExample.size()="+findByExample.size());
		if(findByExample.size()!=0){
			return true;
		}
		return false;
	}

	@Override
	public User findByUser2(User user) {
		List<User> findByExample = this.getHibernateTemplate().findByExample(user);	
		User user3 = null;
		if(findByExample.size()!=0){
			for(User user2:findByExample) {
			 user3=user2;
			}
			return user3;
		}
		return null;
	}

	@Override
	public User findBySelectUser_Id(String user_id) {
		String sql="from User where user_id="+user_id;
		List<User> list = (List<User>) this.getHibernateTemplate().find(sql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public User findBySelectUser(User user) {
		System.out.println("---idhhhhhh------------------"+user.getUser_id());
		List<User> list = (List<User>) this.getHibernateTemplate().findByExample(user);
		System.out.println("---------------------list.size()="+list.size());
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}


}
