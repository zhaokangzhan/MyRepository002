package dao.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.TestDao;
import dao.TestDao;
import domain.Test;

@Transactional
public class TestDaoImpl extends HibernateDaoSupport implements TestDao{
	
	@Override
	public List<Test> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows) {
		// TODO Auto-generated method stub
		System.out.println("Testdaoimpl中的方法执行了...");
		detachedCriteria.setProjection(null);
		return  (List<Test>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, rows);
		 
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
	public void save(Test test) {
		// TODO Auto-generated method stub
		System.out.println("DAO中的save方法执行了...");
		System.out.println("action中获得的Test答案="+test.getTest_answer());		
		this.getHibernateTemplate().save(test);
		/*String hql="update PersonCounts set Test_counts=(select count(*) from Test)";
		this.getHibernateTemplate().update(hql);*/
	}

	@Override
	public List<Test> findById(String[] arr) {
		List<Test> list=new ArrayList<Test>();
	   ArrayList<Test> realList= new ArrayList<Test>();
	   System.out.println("Testdaoimpl的id数组长度"+arr.length);
		for (int i = 0; i < arr.length; i++) {
			int id = Integer.parseInt(arr[i]);
			String hql="from Test where id="+id;
		 list = (List<Test>) this.getHibernateTemplate().find(hql);
		 if(list.size() > 0){
				realList.add(list.get(0));
			}
		}
		
		return realList;
	}

	@Override
	public void delete(List<Test> list) {
		// TODO Auto-generated method stub
		for(Test test:list){
			this.getHibernateTemplate().delete(test);
			
		}
	}

	@Override
	public Test findBySelectId(String id) {
		int intid=Integer.parseInt(id);
		String sql="from Test where id="+intid;
		List<Test> list = (List<Test>) this.getHibernateTemplate().find(sql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void update(Test test) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(test);;
	}

	@Override
	public int findCounts(Test test) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Test.class);		
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
	public int findTestCounts() {
		// TODO Auto-generated method stub
		/*System.out.println("Test=====findTestCounts方法执行了");
		List<Long> list  = (List<Long>) this.getHibernateTemplate().find("select count(*) from Test");
	
		
		if(list.size()>0){
		return list.get(0).intValue();
		
		}
		return 0;*/
		
		ArrayList<Test> realList = new ArrayList<Test>();
		//String hql = "select * from PersonCounts";

		List<Test> list = (List<Test>) this.getHibernateTemplate().find("from Test");

		if (list.size() > 0) {
			realList.add(list.get(0));

		}
		int flist=realList.size();
		System.out.println(" --------------flist="+flist);
		return flist;
		
		
	}

	@Override
	public List<Test> getRandomTestList() {
		List<Test> list=new ArrayList<Test>();
		  
			 list = (List<Test>) this.getHibernateTemplate().find("from Test");
			
			return list;
	}


}
