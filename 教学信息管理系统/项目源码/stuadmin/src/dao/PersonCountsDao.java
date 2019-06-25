package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Authority;
import domain.PersonCounts;
import domain.Teacher;

public interface PersonCountsDao {

	int findPersonCounts(PersonCounts personCounts);

	void updateTeacherCounts(PersonCounts p);

	List<PersonCounts> findAllPersonCounts(PersonCounts personCounts);

	List<PersonCounts> findAllPersonCounts();

	void updateStudentCounts(PersonCounts p);

	void updateUserCounts(PersonCounts p);
	

	
}
