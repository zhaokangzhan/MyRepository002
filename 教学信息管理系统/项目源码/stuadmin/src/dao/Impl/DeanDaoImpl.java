package dao.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.DeanDao;
import dao.TeacherDao;
import domain.Dean;
import domain.PersonCounts;
import domain.Teacher;

@Transactional
public class DeanDaoImpl extends HibernateDaoSupport implements DeanDao{
	
	@Override
	public List<Dean> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows) {
		// TODO Auto-generated method stub
		System.out.println("deandao中的方法执行了...");
		detachedCriteria.setProjection(null);
		return  (List<Dean>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, rows);
	
		
		 
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
	public void save(Dean dean) {
		// TODO Auto-generated method stub
		System.out.println("DAO中的save方法执行了...");
		System.out.println("action中获得的teacher姓名="+dean.getDean_name());		
		this.getHibernateTemplate().save(dean);
		/*String hql="update PersonCounts set teacher_counts=(select count(*) from Teacher)";
		this.getHibernateTemplate().update(hql);*/
	}

	@Override
	public List<Dean> findById(String[] arr) {
		List<Dean> list=new ArrayList<Dean>();
	   ArrayList<Dean> realList= new ArrayList<Dean>();
	   System.out.println("deandaoimpl的id数组长度"+arr.length);
		for (int i = 0; i < arr.length; i++) {
			int id = Integer.parseInt(arr[i]);
			String hql="from Dean where id="+id;
		 list = (List<Dean>) this.getHibernateTemplate().find(hql);
		 if(list.size() > 0){
				realList.add(list.get(0));
			}
		}
		
		return realList;
	}

	@Override
	public void delete(List<Dean> list) {
		// TODO Auto-generated method stub
		for(Dean dean:list){
			this.getHibernateTemplate().delete(dean);
			
		}
	}

	@Override
	public Dean findBySelectId(String id) {
		int intid=Integer.parseInt(id);
		String sql="from Dean where id="+intid;
		List<Dean> list = (List<Dean>) this.getHibernateTemplate().find(sql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void update(Dean dean) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(dean);;
	}

	@Override
	public int findCounts(Dean dean) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Dean.class);		
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
	public int findTeacherCounts() {
		// TODO Auto-generated method stub
		/*System.out.println("teacher=====findteacherCounts方法执行了");
		List<Long> list  = (List<Long>) this.getHibernateTemplate().find("select count(*) from teacher");
	
		
		if(list.size()>0){
		return list.get(0).intValue();
		
		}
		return 0;*/
		
		ArrayList<Dean> realList = new ArrayList<Dean>();
		//String hql = "select * from PersonCounts";

		List<Dean> list = (List<Dean>) this.getHibernateTemplate().find("from dean");

		if (list.size() > 0) {
			realList.add(list.get(0));

		}
		int flist=realList.size();
		System.out.println(" --------------flist="+flist);
		return flist;
		
		
	}


}
