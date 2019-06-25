package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.PageBean;
import domain.Student;

public interface StudentService {
	


	PageBean<Student> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows);

	void save(Student student);

	Student findBySelectId(String id);

	void update(Student student);

	List<Student> findById(String[] arr);

	void delete(List<Student> list);

	int findCounts(Student student);
	
}
