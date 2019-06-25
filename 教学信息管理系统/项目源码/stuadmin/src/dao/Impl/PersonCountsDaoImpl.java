package dao.Impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.PersonCountsDao;
import dao.TeacherDao;
import domain.PersonCounts;
import domain.Teacher;

@Transactional
public class PersonCountsDaoImpl extends HibernateDaoSupport implements PersonCountsDao {

	@Override
	public int findPersonCounts(PersonCounts personCounts) {
		// TODO Auto-generated method stub

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(PersonCounts.class);
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		System.out.println(list.size());

		if (list.size() > 0) {
			return list.get(0).intValue();

		}
		return 0;
	}

	@Override
	public void updateTeacherCounts(PersonCounts p) {
		// TODO Auto-generated method stub

		this.getHibernateTemplate().update(p);
	}

	

	@Override
	public List<PersonCounts> findAllPersonCounts(PersonCounts personCounts) {
		ArrayList<PersonCounts> realList = new ArrayList<PersonCounts>();
		//String hql = "select * from PersonCounts";

		List<PersonCounts> list = (List<PersonCounts>)this.getHibernateTemplate().find("from PersonCounts");

		if (list.size() > 0) {
			realList.add(list.get(0));

		}

		return realList;

	}

	@Override
	public List<PersonCounts> findAllPersonCounts() {
		// TODO Auto-generated method stub
		return (List<PersonCounts>) this.getHibernateTemplate().find("from PersonCounts");
	}

	@Override
	public void updateStudentCounts(PersonCounts p) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(p);
	}

	@Override
	public void updateUserCounts(PersonCounts p) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(p);
	}

}
