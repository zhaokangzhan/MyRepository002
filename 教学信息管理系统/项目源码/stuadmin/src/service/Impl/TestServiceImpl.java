package service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;


import dao.TestDao;

import domain.PageBean;
import domain.Test;

@Transactional
public class TestServiceImpl implements service.TestService {

	private TestDao testDao;

	
	public TestDao getTestDao() {
		return testDao;
	}


	public void setTestDao(TestDao testDao) {
		this.testDao = testDao;
	}


	@Override
	public PageBean<Test> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		System.out.println("Testserviceimpl中的方法执行了...");
		PageBean<Test> pageBean = new PageBean<Test>();
		pageBean.setCurrPage(page);
		pageBean.setPageSize(rows);
		Integer totalCount = testDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / rows);
		pageBean.setTotalPage(num.intValue());
		Integer begin = (page - 1) * rows;
		List<Test> list = testDao.findByPage(detachedCriteria, begin, rows);
		pageBean.setList(list);
		return pageBean;
	}


	@Override
	public void save(Test test) {
		// TODO Auto-generated method stub
		System.out.println("Service中的save方法执行了...");
		System.out.println("action中获得的Test答案="+test.getTest_answer());

		testDao.save(test);
		
		
	}


	@Override
	public List<Test> findById(String[] arr) {
		// TODO Auto-generated method stub
		return testDao.findById(arr);
	}


	@Override
	public void delete(List<Test> list) {
		// TODO Auto-generated method stub
		testDao.delete(list);
	}


	@Override
	public Test findBySelectId(String id) {
		// TODO Auto-generated method stub
		return testDao.findBySelectId(id);
	}


	@Override
	public void update(Test test) {
		testDao.update(test);
	}


	@Override
	public int findCounts(Test test) {
		// TODO Auto-generated method stub
		return testDao.findCounts(test);
	}


	@Override
	public int findCounts(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return testDao.findCounts(detachedCriteria);
	}


	@Override
	public List<Test> getRandomTestList() {
		// TODO Auto-generated method stub
		return testDao.getRandomTestList();
	}


	

	
	


}
