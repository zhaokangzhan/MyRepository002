package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;


import domain.PageBean;
import domain.User;


public interface UserService {
	
	
	
	PageBean<User> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows);

	void save(User user);

	List<User> findById(String[] arr);

	void delete(List<User> list);

	User findBySelectId(String id);

	void update(User user);

	int findCounts(User user);

	int findCounts(DetachedCriteria detachedCriteria);

	int findAllUserCounts();

	Boolean findByUser(User user);

	User findByUser2(User user);

	User findBySelectUser_Id(String user_id);

	User findBySelectUser(User user);





}
