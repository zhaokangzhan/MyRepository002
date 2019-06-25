package service.Impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import dao.AuthorityDao;
import dao.Impl.AuthorityDaoImpl;
import domain.Authority;
import domain.PageBean;

@Transactional
public class AuthorityServiceImpl implements service.AuthorityService {

	private AuthorityDao authorityDao;

	public void setAuthorityDao(AuthorityDao authorityDao) {
		this.authorityDao = authorityDao;
	}

	public AuthorityDao getAuthorityDao() {
		return authorityDao;
	}

	@Override
	public PageBean<Authority> findByPage(DetachedCriteria detachedCriteria, Integer page, Integer rows) {
		// TODO Auto-generated method stub
		PageBean<Authority> pageBean = new PageBean<Authority>();
		pageBean.setCurrPage(page);
		pageBean.setPageSize(rows);
		Integer totalCount = authorityDao.findCount(detachedCriteria);
		pageBean.setTotalCount(totalCount);
		double tc = totalCount;
		Double num = Math.ceil(tc / rows);
		pageBean.setTotalPage(num.intValue());
		Integer begin = (page - 1) * rows;
		List<Authority> list = authorityDao.findByPage(detachedCriteria, begin, rows);
		pageBean.setList(list);
		return pageBean;
	}

	
	public void save(Authority authority) {
		// TODO Auto-generated method stub
		System.out.println("Service中的save方法执行了...");
		System.out.println("action中获得的authority角色="+authority.getRole());
		authorityDao.save(authority);
	}

	@Override
	public List<Authority> findById(String[] arr) {
		// TODO Auto-generated method stub
		return authorityDao.findById(arr);
	}

	@Override
	public void delete(List<Authority> list) {
		// TODO Auto-generated method stub
		authorityDao.delete(list);
	}

	@Override
	public Authority findBySelectId(String id) {
		// TODO Auto-generated method stub
		return authorityDao.findBySelectId(id);
	}

	@Override
	public void update(Authority authority) {
		// TODO Auto-generated method stub
		authorityDao.update(authority);
	}

}
