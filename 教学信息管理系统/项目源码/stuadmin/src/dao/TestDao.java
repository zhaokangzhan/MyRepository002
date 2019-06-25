package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Authority;
import domain.Teacher;
import domain.Test;

public interface TestDao {
	
	
	List<Test> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows);
	Integer findCount(DetachedCriteria detachedCriteria);
	/*void save(Authority authority);
	Authority findBySelectId(String id);
	void update(Authority authority);*/
	void save(Test test);
	List<Test> findById(String[] arr);
	void delete(List<Test> list);
	Test findBySelectId(String id);
	void update(Test test);
	int findCounts(Test test);
	int findCounts(DetachedCriteria detachedCriteria);
	int findTestCounts();
	List<Test> getRandomTestList();
}
