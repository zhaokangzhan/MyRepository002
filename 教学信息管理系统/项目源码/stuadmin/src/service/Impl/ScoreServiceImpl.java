package service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;


import dao.ScoreDao;

import domain.PageBean;
import domain.Score;

@Transactional
public class ScoreServiceImpl implements service.ScoreService {

	private ScoreDao scoreDao;

	
	public ScoreDao getScoreDao() {
		return scoreDao;
	}


	public void setScoreDao(ScoreDao scoreDao) {
		this.scoreDao = scoreDao;
	}


	@Override
	public PageBean<Score> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		System.out.println("Scoreserviceimpl中的方法执行了...");
		PageBean<Score> pageBean = new PageBean<Score>();
		pageBean.setCurrPage(page);
		pageBean.setPageSize(rows);
		Integer totalCount = scoreDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / rows);
		pageBean.setTotalPage(num.intValue());
		Integer begin = (page - 1) * rows;
		List<Score> list = scoreDao.findByPage(detachedCriteria, begin, rows);
		pageBean.setList(list);
		return pageBean;
	}


	@Override
	public void save(Score score) {
		// TODO Auto-generated method stub
		System.out.println("Service中的save方法执行了...");
		

		scoreDao.save(score);
		
		
	}


	@Override
	public List<Score> findById(String[] arr) {
		// TODO Auto-generated method stub
		return scoreDao.findById(arr);
	}


	@Override
	public void delete(List<Score> list) {
		// TODO Auto-generated method stub
		scoreDao.delete(list);
	}


	@Override
	public Score findBySelectId(String id) {
		// TODO Auto-generated method stub
		return scoreDao.findBySelectId(id);
	}


	@Override
	public void update(Score score) {
		scoreDao.update(score);
	}


	@Override
	public int findCounts(Score score) {
		// TODO Auto-generated method stub
		return scoreDao.findCounts(score);
	}


	@Override
	public int findCounts(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return scoreDao.findCounts(detachedCriteria);
	}


	@Override
	public List<Score> getRandomScoreList() {
		// TODO Auto-generated method stub
		return scoreDao.getRandomScoreList();
	}


	@Override
	public void saveScoreAfterTest(Score score) {
		scoreDao.saveScoreAfterTest(score);
		
	}


	@Override
	public List<Score> findByScore(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return scoreDao.findByScore(detachedCriteria);
	}


	@Override
	public void updateScoreAfterTest(Score score2) {
		// TODO Auto-generated method stub
		scoreDao.updateScoreAfterTest(score2);
	}


}
