package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Authority;
import domain.Teacher;

public interface TeacherDao {
	
	
	List<Teacher> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows);
	Integer findCount(DetachedCriteria detachedCriteria);
	/*void save(Authority authority);
	Authority findBySelectId(String id);
	void update(Authority authority);*/
	void save(Teacher teacher);
	List<Teacher> findById(String[] arr);
	void delete(List<Teacher> list);
	Teacher findBySelectId(String id);
	void update(Teacher teacher);
	int findCounts(Teacher teacher);
	int findCounts(DetachedCriteria detachedCriteria);
	int findTeacherCounts();
}
