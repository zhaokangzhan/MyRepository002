package service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import domain.Authority;
import domain.PageBean;


public interface AuthorityService {
	
	
	
	PageBean<Authority> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows);


	void save(Authority authority);


	List<Authority>findById(String[] arr);


	void delete(List<Authority> list);


	Authority findBySelectId(String id);


	void update(Authority authority);
}
