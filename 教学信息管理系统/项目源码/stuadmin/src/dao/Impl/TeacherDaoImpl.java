package dao.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.TeacherDao;
import domain.PersonCounts;
import domain.Teacher;

@Transactional
public class TeacherDaoImpl extends HibernateDaoSupport implements TeacherDao{
	
	@Override
	public List<Teacher> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows) {
		// TODO Auto-generated method stub
		System.out.println("teacherdaoimpl中的方法执行了...");
		detachedCriteria.setProjection(null);
		return  (List<Teacher>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, rows);
	
		
		 
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
	public void save(Teacher teacher) {
		// TODO Auto-generated method stub
		System.out.println("DAO中的save方法执行了...");
		System.out.println("action中获得的teacher姓名="+teacher.getTeacher_name());		
		this.getHibernateTemplate().save(teacher);
		/*String hql="update PersonCounts set teacher_counts=(select count(*) from Teacher)";
		this.getHibernateTemplate().update(hql);*/
	}

	@Override
	public List<Teacher> findById(String[] arr) {
		List<Teacher> list=new ArrayList<Teacher>();
	   ArrayList<Teacher> realList= new ArrayList<Teacher>();
	   System.out.println("teacherdaoimpl的id数组长度"+arr.length);
		for (int i = 0; i < arr.length; i++) {
			int id = Integer.parseInt(arr[i]);
			String hql="from Teacher where id="+id;
		 list = (List<Teacher>) this.getHibernateTemplate().find(hql);
		 if(list.size() > 0){
				realList.add(list.get(0));
			}
		}
		
		return realList;
	}

	@Override
	public void delete(List<Teacher> list) {
		// TODO Auto-generated method stub
		for(Teacher teacher:list){
			this.getHibernateTemplate().delete(teacher);
			
		}
	}

	@Override
	public Teacher findBySelectId(String id) {
		int intid=Integer.parseInt(id);
		String sql="from Teacher where id="+intid;
		List<Teacher> list = (List<Teacher>) this.getHibernateTemplate().find(sql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void update(Teacher teacher) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(teacher);;
	}

	@Override
	public int findCounts(Teacher teacher) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Teacher.class);		
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
		
		ArrayList<Teacher> realList = new ArrayList<Teacher>();
		//String hql = "select * from PersonCounts";

		List<Teacher> list = (List<Teacher>) this.getHibernateTemplate().find("from teacher");

		if (list.size() > 0) {
			realList.add(list.get(0));

		}
		int flist=realList.size();
		System.out.println(" --------------flist="+flist);
		return flist;
		
		
	}


}
