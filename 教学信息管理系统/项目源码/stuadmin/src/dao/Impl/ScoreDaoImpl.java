package dao.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.ScoreDao;
import dao.ScoreDao;
import domain.Score;

@Transactional
public class ScoreDaoImpl extends HibernateDaoSupport implements ScoreDao{
	
	@Override
	public List<Score> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows) {
		// TODO Auto-generated method stub
		System.out.println("Scoredaoimpl中的方法执行了...");
		detachedCriteria.setProjection(null);
		return  (List<Score>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, rows);
		 
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
	public void save(Score score) {
		// TODO Auto-generated method stub
		System.out.println("DAO中的save方法执行了...");
			
		this.getHibernateTemplate().save(score);
		/*String hql="update PersonCounts set Score_counts=(select count(*) from Score)";
		this.getHibernateTemplate().update(hql);*/
	}

	@Override
	public List<Score> findById(String[] arr) {
		List<Score> list=new ArrayList<Score>();
	   ArrayList<Score> realList= new ArrayList<Score>();
	   System.out.println("Scoredaoimpl的id数组长度"+arr.length);
		for (int i = 0; i < arr.length; i++) {
			int id = Integer.parseInt(arr[i]);
			String hql="from Score where id="+id;
		 list = (List<Score>) this.getHibernateTemplate().find(hql);
		 if(list.size() > 0){
				realList.add(list.get(0));
			}
		}
		
		return realList;
	}

	@Override
	public void delete(List<Score> list) {
		// TODO Auto-generated method stub
		for(Score score:list){
			this.getHibernateTemplate().delete(score);
			
		}
	}

	@Override
	public Score findBySelectId(String id) {
		int intid=Integer.parseInt(id);
		String sql="from Score where id="+intid;
		List<Score> list = (List<Score>) this.getHibernateTemplate().find(sql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public void update(Score score) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(score);;
	}

	@Override
	public int findCounts(Score score) {
		// TODO Auto-generated method stub
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Score.class);		
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
	public int findScoreCounts() {
	
		
		ArrayList<Score> realList = new ArrayList<Score>();
		//String hql = "select * from PersonCounts";

		List<Score> list = (List<Score>) this.getHibernateTemplate().find("from Score");

		if (list.size() > 0) {
			realList.add(list.get(0));

		}
		int flist=realList.size();
		System.out.println(" --------------flist="+flist);
		return flist;
	
	}

	@Override
	public List<Score> getRandomScoreList() {
		List<Score> list=new ArrayList<Score>();
		  
			 list = (List<Score>) this.getHibernateTemplate().find("from Score");
			
			return list;
	}

	@Override
	public void saveScoreAfterTest(Score score) {
		this.getHibernateTemplate().save(score);
	}

	@Override
	public List<Score> findByScore(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(null);
		return  (List<Score>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		 
	}

	@Override
	public void updateScoreAfterTest(Score score2) {
		this.getHibernateTemplate().update(score2);
	}


}
