package service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import dao.AuthorityDao;
import dao.TeacherDao;
import dao.Impl.AuthorityDaoImpl;
import domain.Authority;
import domain.PageBean;
import domain.Teacher;

@Transactional
public class TeacherServiceImpl implements service.TeacherService {

	private TeacherDao teacherDao;

	
	public TeacherDao getTeacherDao() {
		return teacherDao;
	}


	public void setTeacherDao(TeacherDao teacherDao) {
		this.teacherDao = teacherDao;
	}


	@Override
	public PageBean<Teacher> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		System.out.println("teacherserviceimpl中的方法执行了...");
		PageBean<Teacher> pageBean = new PageBean<Teacher>();
		pageBean.setCurrPage(page);
		pageBean.setPageSize(rows);
		Integer totalCount = teacherDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / rows);
		pageBean.setTotalPage(num.intValue());
		Integer begin = (page - 1) * rows;
		List<Teacher> list = teacherDao.findByPage(detachedCriteria, begin, rows);
		pageBean.setList(list);
		return pageBean;
	}


	@Override
	public void save(Teacher teacher) {
		// TODO Auto-generated method stub
		System.out.println("Service中的save方法执行了...");
		System.out.println("action中获得的teacher姓名="+teacher.getTeacher_name());

		teacherDao.save(teacher);
		
		
	}


	@Override
	public List<Teacher> findById(String[] arr) {
		// TODO Auto-generated method stub
		return teacherDao.findById(arr);
	}


	@Override
	public void delete(List<Teacher> list) {
		// TODO Auto-generated method stub
		teacherDao.delete(list);
	}


	@Override
	public Teacher findBySelectId(String id) {
		// TODO Auto-generated method stub
		return teacherDao.findBySelectId(id);
	}


	@Override
	public void update(Teacher teacher) {
		teacherDao.update(teacher);
	}


	@Override
	public int findCounts(Teacher teacher) {
		// TODO Auto-generated method stub
		return teacherDao.findCounts(teacher);
	}


	@Override
	public int findCounts(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return teacherDao.findCounts(detachedCriteria);
	}


	@Override
	public int findAllTeacherCounts() {
		// TODO Auto-generated method stub
		return teacherDao.findTeacherCounts();
	}

	


}
