package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Dean;
import domain.PageBean;
import domain.Teacher;


public interface DeanService {
	
	
	
	PageBean<Dean> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows);

	void save(Dean dean);

	List<Dean> findById(String[] arr);

	void delete(List<Dean> list);

	Dean findBySelectId(String id);

	void update(Dean dean);

	int findCounts(Dean dean);

	int findCounts(DetachedCriteria detachedCriteria);

	int findAllTeacherCounts();




}
