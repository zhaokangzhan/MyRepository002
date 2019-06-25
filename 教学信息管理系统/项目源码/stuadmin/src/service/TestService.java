package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


import domain.PageBean;
import domain.Test;


public interface TestService {
	
	
	
	PageBean<Test> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows);

	void save(Test test);

	List<Test> findById(String[] arr);

	void delete(List<Test> list);

	Test findBySelectId(String id);

	void update(Test test);

	int findCounts(Test test);

	int findCounts(DetachedCriteria detachedCriteria);

	List<Test> getRandomTestList();



}
