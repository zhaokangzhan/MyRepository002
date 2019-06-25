package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Authority;
import domain.Dean;
import domain.Teacher;

public interface DeanDao {
	
	
	List<Dean> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows);
	Integer findCount(DetachedCriteria detachedCriteria);
	/*void save(Authority authority);
	Authority findBySelectId(String id);
	void update(Authority authority);*/
	void save(Dean dean);
	List<Dean> findById(String[] arr);
	void delete(List<Dean> list);
	Dean findBySelectId(String id);
	void update(Dean dean);
	int findCounts(Dean dean);
	int findCounts(DetachedCriteria detachedCriteria);
	int findTeacherCounts();
}
