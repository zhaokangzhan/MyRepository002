package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


import domain.PageBean;
import domain.PersonCounts;
import domain.Teacher;


public interface PersonCountsService {

	int findPersonCounts(PersonCounts personCounts);

	void updateTeacherCounts(PersonCounts p);

	void updateUserCounts(PersonCounts p);
	List<PersonCounts> findAllPersonCounts(PersonCounts personCounts);

	List<PersonCounts> findAllPersonCounts();

	void updateStudentCounts(PersonCounts p);
	
	
	


}
