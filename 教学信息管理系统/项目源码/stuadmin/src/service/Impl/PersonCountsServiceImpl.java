package service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import dao.PersonCountsDao;
import dao.StudentDao;
import domain.PageBean;
import domain.PersonCounts;

@Transactional
public class PersonCountsServiceImpl implements service.PersonCountsService {
private PersonCountsDao personCountsDao;

	public PersonCountsDao getPersonCountsDao() {
	return personCountsDao;
}

public void setPersonCountsDao(PersonCountsDao personCountsDao) {
	this.personCountsDao = personCountsDao;
}

	@Override
	public int findPersonCounts(PersonCounts personCounts) {
		// TODO Auto-generated method stub
		return personCountsDao.findPersonCounts(personCounts);
	}

	@Override
	public void updateTeacherCounts(PersonCounts p) {
		// TODO Auto-generated method stub
		personCountsDao.updateTeacherCounts(p);
	}

	
	@Override
	public List<PersonCounts> findAllPersonCounts(PersonCounts personCounts) {
		// TODO Auto-generated method stub
		return personCountsDao.findAllPersonCounts(personCounts);
	}

	@Override
	public List<PersonCounts> findAllPersonCounts() {
		// TODO Auto-generated method stub
		return personCountsDao.findAllPersonCounts();
	}

	@Override
	public void updateStudentCounts(PersonCounts p) {
		// TODO Auto-generated method stub
		personCountsDao.updateStudentCounts(p);
	}

	@Override
	public void updateUserCounts(PersonCounts p) {
		// TODO Auto-generated method stub
		personCountsDao.updateUserCounts(p);
	}

	
	


}
