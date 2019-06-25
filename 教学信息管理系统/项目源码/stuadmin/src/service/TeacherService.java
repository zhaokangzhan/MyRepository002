package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


import domain.PageBean;
import domain.Teacher;


public interface TeacherService {
	
	
	
	PageBean<Teacher> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows);

	void save(Teacher teacher);

	List<Teacher> findById(String[] arr);

	void delete(List<Teacher> list);

	Teacher findBySelectId(String id);

	void update(Teacher teacher);

	int findCounts(Teacher teacher);

	int findCounts(DetachedCriteria detachedCriteria);

	int findAllTeacherCounts();




}
