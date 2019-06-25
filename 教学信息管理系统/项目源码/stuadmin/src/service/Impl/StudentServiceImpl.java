package service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


import dao.StudentDao;
import domain.PageBean;
import domain.Student;

public class StudentServiceImpl implements service.StudentService {
	private StudentDao studentDao;
	

	public StudentDao getStudentDao() {
		return studentDao;
	}


	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}



	@Override
	public PageBean<Student> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		PageBean<Student> pageBean = new PageBean<Student>();
		pageBean.setCurrPage(page);
		pageBean.setPageSize(rows);
		Integer totalCount = studentDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / rows);
		pageBean.setTotalPage( num.intValue());
		Integer begin = (page - 1 )* rows;
		List<Student> list = studentDao.findByPage(detachedCriteria,begin,rows);
		pageBean.setList(list);
		return pageBean;
	}


	@Override
	public void save(Student student) {
		// TODO Auto-generated method stub
		studentDao.save(student);
	}


	@Override
	public Student findBySelectId(String id) {
		// TODO Auto-generated method stub
		return studentDao.findByPageSelectId(id);
	}


	@Override
	public void update(Student student) {
		// TODO Auto-generated method stub
		studentDao.update(student);
	}


	@Override
	public List<Student> findById(String[] arr) {
		// TODO Auto-generated method stub
		return studentDao.findById(arr);
	}


	@Override
	public void delete(List<Student> list) {
		studentDao.delete(list);
	}


	@Override
	public int findCounts(Student student) {
		// TODO Auto-generated method stub
		return studentDao.findCount(student);
	}


	


}
