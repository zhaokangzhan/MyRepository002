package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.PersonCounts;
import domain.Student;

public interface StudentDao {
	
	void save(Student student);
	void update(Student student);
	void delete(List<Student> list);
	List<Student> findById(String[] arr);
	List<Student> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows);
	Integer findCount(DetachedCriteria detachedCriteria);
	Student findByPageSelectId(String id);
	int findCount(Student student);
	void updateStudentCounts(PersonCounts p);
}
