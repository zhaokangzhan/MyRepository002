package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Authority;
import domain.User;

public interface UserDao {
	
	
	List<User> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows);
	Integer findCount(DetachedCriteria detachedCriteria);
	/*void save(Authority authority);
	Authority findBySelectId(String id);
	void update(Authority authority);*/
	void save(User user);
	List<User> findById(String[] arr);
	void delete(List<User> list);
	User findBySelectId(String id);
	void update(User user);
	int findCounts(User user);
	int findCounts(DetachedCriteria detachedCriteria);
	int findUserCounts();
	Boolean findByUser(User user);
	User findByUser2(User user);
	User findBySelectUser_Id(String user_id);
	User findBySelectUser(User user);
}
