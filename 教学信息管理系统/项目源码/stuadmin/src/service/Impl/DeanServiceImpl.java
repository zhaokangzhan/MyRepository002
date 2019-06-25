package service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import dao.AuthorityDao;
import dao.DeanDao;
import dao.TeacherDao;
import dao.Impl.AuthorityDaoImpl;
import domain.Authority;
import domain.Dean;
import domain.PageBean;
import domain.Teacher;

@Transactional
public class DeanServiceImpl implements service.DeanService {

	private DeanDao deanDao;
public DeanDao getDeanDao() {
		return deanDao;
	}


	public void setDeanDao(DeanDao deanDao) {
		this.deanDao = deanDao;
	}


	@Override
	public PageBean<Dean> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		System.out.println("teacherserviceimpl中的方法执行了...");
		PageBean<Dean> pageBean = new PageBean<Dean>();
		pageBean.setCurrPage(page);
		pageBean.setPageSize(rows);
		Integer totalCount = deanDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / rows);
		pageBean.setTotalPage(num.intValue());
		Integer begin = (page - 1) * rows;
		List<Dean> list = deanDao.findByPage(detachedCriteria, begin, rows);
		pageBean.setList(list);
		return pageBean;
	}


	@Override
	public void save(Dean dean) {
		// TODO Auto-generated method stub
		System.out.println("Service中的save方法执行了...");
		System.out.println("action中获得的teacher姓名="+dean.getDean_name());

		deanDao.save(dean);
		
		
	}


	@Override
	public List<Dean> findById(String[] arr) {
		// TODO Auto-generated method stub
		return deanDao.findById(arr);
	}


	@Override
	public void delete(List<Dean> list) {
		// TODO Auto-generated method stub
		deanDao.delete(list);
	}


	@Override
	public Dean findBySelectId(String id) {
		// TODO Auto-generated method stub
		return deanDao.findBySelectId(id);
	}


	@Override
	public void update(Dean dean) {
		deanDao.update(dean);
	}


	@Override
	public int findCounts(Dean dean) {
		// TODO Auto-generated method stub
		return deanDao.findCounts(dean);
	}


	@Override
	public int findCounts(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return deanDao.findCounts(detachedCriteria);
	}


	@Override
	public int findAllTeacherCounts() {
		// TODO Auto-generated method stub
		return deanDao.findTeacherCounts();
	}

	


}
