package service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import dao.AuthorityDao;
import dao.UserDao;
import dao.Impl.AuthorityDaoImpl;
import domain.Authority;
import domain.PageBean;
import domain.User;

@Transactional
public class UserServiceImpl implements service.UserService {

	private UserDao userDao;

	
	public UserDao getUserDao() {
		return userDao;
	}


	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public PageBean<User> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		System.out.println("Userserviceimpl中的方法执行了...");
		PageBean<User> pageBean = new PageBean<User>();
		pageBean.setCurrPage(page);
		pageBean.setPageSize(rows);
		Integer totalCount = userDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / rows);
		pageBean.setTotalPage(num.intValue());
		Integer begin = (page - 1) * rows;
		List<User> list = userDao.findByPage(detachedCriteria, begin, rows);
		pageBean.setList(list);
		return pageBean;
	}


	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		System.out.println("Service中的save方法执行了...");
		System.out.println("action中获得的User姓名="+user.getUser_name());

		userDao.save(user);
		
		
	}


	@Override
	public List<User> findById(String[] arr) {
		// TODO Auto-generated method stub
		return userDao.findById(arr);
	}


	@Override
	public void delete(List<User> list) {
		// TODO Auto-generated method stub
		userDao.delete(list);
	}


	@Override
	public User findBySelectId(String id) {
		// TODO Auto-generated method stub
		return userDao.findBySelectId(id);
	}


	@Override
	public void update(User user) {
		userDao.update(user);
	}


	@Override
	public int findCounts(User user) {
		// TODO Auto-generated method stub
		return userDao.findCounts(user);
	}


	@Override
	public int findCounts(DetachedCriteria detachedCriteria) {
		// TODO Auto-generated method stub
		return userDao.findCounts(detachedCriteria);
	}


	@Override
	public int findAllUserCounts() {
		// TODO Auto-generated method stub
		return userDao.findUserCounts();
	}


	@Override
	public Boolean findByUser(User user) {
		// TODO Auto-generated method stub
		return userDao.findByUser(user);
	}


	@Override
	public User findByUser2(User user) {
		// TODO Auto-generated method stub
		return userDao.findByUser2(user);
	}


	@Override
	public User findBySelectUser_Id(String user_id) {
		// TODO Auto-generated method stub
		return userDao.findBySelectUser_Id(user_id);
	}


	@Override
	public User findBySelectUser(User user) {
		// TODO Auto-generated method stub
		return userDao.findBySelectUser(user);
	}

	


}
