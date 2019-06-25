package dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Authority;

public interface AuthorityDao {
	
	
	List<Authority> findByPage(DetachedCriteria detachedCriteria, Integer begin, Integer rows);
	Integer findCount(DetachedCriteria detachedCriteria);
	void save(Authority authority);
	List<Authority> findById(String[] arr);
	void delete(List<Authority> list);
	Authority findBySelectId(String id);
	void update(Authority authority);
}
