package dao.Impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import dao.StudentDao;
import domain.PersonCounts;
import domain.Student;
import domain.Teacher;
@Transactional
public class StudentDaoImpl extends HibernateDaoSupport implements dao.StudentDao {

	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().save(student);
	}

@Override
	public List<Student> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows) {
		// TODO Auto-generated method stub
		detachedCriteria.setProjection(null);
		return (List<Student>) this.getHibernateTemplate().findByCriteria(detachedCriteria, begin, rows);
	}

	@Override
	public Integer findCount(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list  = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return null;
	}

	@Override
	public Student findByPageSelectId(String id) {
		int intid=Integer.parseInt(id);
		String sql="from Student where id="+intid;
		List<Student> list = (List<Student>) this.getHibernateTemplate().find(sql);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public void update(Student student) {
		this.getHibernateTemplate().update(student);
		
	}


	@Override
	public List<Student> findById(String[] arr) {
		List<Student> list=new ArrayList<Student>();
		   ArrayList<Student> realList= new ArrayList<Student>();
		   System.out.println("studentdaoimpl的id数组长度"+arr.length);
			for (int i = 0; i < arr.length; i++) {
				int id = Integer.parseInt(arr[i]);
				String hql="from Student where id="+id;
			 list = (List<Student>) this.getHibernateTemplate().find(hql);
			 if(list.size() > 0){
					realList.add(list.get(0));
				}
			}
			
			return realList;
	}

	@Override
	public void delete(List<Student> list) {
		for(Student student:list){
			this.getHibernateTemplate().delete(student);
		}
		
	}

	@Override
	public int findCount(Student student) {

		ArrayList<Student> realList = new ArrayList<Student>();
		//String hql = "select * from PersonCounts";

		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Student.class);		
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> list  = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(list.size()>0){
		return list.get(0).intValue();
		
		}
		return 0;
	}

	@Override
	public void updateStudentCounts(PersonCounts p) {
		// TODO Auto-generated method stub
		this.getHibernateTemplate().update(p);
	}

}
