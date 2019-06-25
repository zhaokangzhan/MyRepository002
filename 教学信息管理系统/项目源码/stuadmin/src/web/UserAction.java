package web;

import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.logging.log4j.core.util.UuidUtil;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.PageBean;
import domain.PersonCounts;
import domain.User;
import net.sf.json.JSONObject;
import service.PersonCountsService;
import service.UserService;

public class UserAction extends ActionSupport implements ModelDriven<User> {

	// 模型驱动使用的对象
	private User user = new User();

	public User getUser() {
		return user;
	}

	private PersonCountsService personCountsService;

	public PersonCountsService getPersonCountsService() {
		return personCountsService;
	}

	public void setPersonCountsService(PersonCountsService personCountsService) {
		this.personCountsService = personCountsService;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public User getModel() {
		return user;
	}

	// 注入Service
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	// 接收分页的数据：
	// 接收当前页数和每页显示的记录数，这两个值在easyUI中已经有规定。page当前页数，rows每页显示记录数
	private Integer page = 1;
	private Integer rows = 3;

	public void setPage(Integer page) {
		this.page = page;
	}

	public void setRows(Integer rows) {
		this.rows = rows;
	}

	public String user() throws IOException {
		System.out.println("action中的User()方法执行了...");
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(User.class);
		// 调用业务层:
		PageBean<User> pageBean = userService.findByPage(detachedCriteria, page, rows);
		// 使用jsonlib或者fastjson

		System.out.println("======================" + pageBean.getList().size());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("total", pageBean.getTotalCount());
		map.put("rows", pageBean.getList());

		// JSONArray,JSONObject
		JSONObject jsonObject = JSONObject.fromObject(map);
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonObject.toString());
		return NONE;

	}

	public String save() throws IOException {
		System.out.println("action中的save方法执行了...");
		Map<String, String> map = new HashMap<String, String>();
		/*
		 * System.out.println("action--------save()中获得的 姓名=" +
		 * user.getUser_name());
		 */
		try {
			/* System.out.println("action中的try方法执行了..."); */
			String user_uuid = UUID.randomUUID().toString().replace("-", "");
			user.setUser_uuid(user_uuid);
			userService.save(user);

			int counts = userService.findCounts(user);
			System.out.println("=========================counts=" + counts);
			List<PersonCounts> list = personCountsService.findAllPersonCounts();

			PersonCounts p = new PersonCounts();
			for (PersonCounts personCounts : list) {
				System.out.println("PersonCountsAction-----方法查出来的数据PersonCounts=" + personCounts.getUser_counts());
				p = personCounts;
			}

			p.setUser_counts(String.valueOf(counts));

			personCountsService.updateUserCounts(p);

			map.put("msg", "提交成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("msg", "提交失败");
		}
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonObject.toString());
		return NONE;
	}

	public String delete() throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		String ids = ServletActionContext.getRequest().getParameter("ids");
		String[] arr = ids.split(",");
		try {

			List<User> list = userService.findById(arr);
			for (User User : list) {
				System.out.println("UserAction-----delete方法查出来的数据------教师姓名:" + User.getUser_name());
			}
			userService.delete(list);

			map.put("msg", "删除成功!");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "删除失败!");
		}
		// 将map转成JSON:
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonObject.toString());// {"msg":..}

		return NONE;
	}

	public String edit() throws IOException {

		String id = ServletActionContext.getRequest().getParameter("id");

		user = userService.findBySelectId(id);

		System.out.println("编辑=====查出来的激活状态:" + user.getUser_active());

		JSONObject jsonObject = JSONObject.fromObject(user);
		// ServletActionContext.getRequest().getSession().setAttribute("authority",
		// authority);
		System.out.println(jsonObject.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonObject.toString());//
		// {"msg":..}
		return NONE;
	}

	public String search() throws IOException {

		String user_id = ServletActionContext.getRequest().getParameter("user_id");
		user.setUser_id(user_id);
		// user = userService.findBySelectUser_Id(user_id);
		User user2=new User();
		user2 = userService.findBySelectUser(user);
		
	if (user2 == null) {
			System.out.println("-----------------------查询到user为null");
			return NONE;
		}
		JSONObject jsonObject = JSONObject.fromObject(user2);
		// ServletActionContext.getRequest().getSession().setAttribute("authority",
		// authority);
		System.out.println(jsonObject.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonObject.toString());//
		// {"msg":..}
		return NONE;
	}

	public String update() throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		try {
			System.out.println("Action中的update方法执行了...");
			// 调用业务层:
			userService.update(user);
			map.put("msg", "修改成功!");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "修改失败!");
		}
		// 将map转成JSON:
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonObject.toString());// {"msg":..}

		return NONE;
	}

	public String findcounts() throws IOException {

		System.out.println("=====findcounts方法执行啦");
		int counts = userService.findCounts(user);
		JSONObject jsonObject = JSONObject.fromObject(counts);
		System.out.println("=====findcounts获得数据记录counts=" + counts);
		// ServletActionContext.getRequest().getSession().setAttribute("authority",
		// authority);

		System.out.println("counts=" + counts);
		System.out.println("jsonObject.toString()" + jsonObject.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");

		ServletActionContext.getResponse().getWriter().println(jsonObject);
		return NONE;
	}

	public String check() throws IOException {
		System.out.println("action中的check方法执行了...");
		Map<String, String> map = new HashMap<String, String>();

		System.out.println("action--------check()中获得的 账号=" + user.getUser_id());

		System.out.println("action中的try方法执行了...");

		// Boolean flag=userService.findByUser(user);

		try {
			User user4 = userService.findByUser2(user);

			if (user4 != null) {
				System.out.println("登录成功");
				map.put("msg", "登录成功");
				ServletActionContext.getRequest().getSession().setAttribute("user", user4);
				return "touser_test";
			} else {
				System.out.println("登录失败");
				map.put("msg", "登录失败,账号密码不正确");
				ServletActionContext.getRequest().getSession().setAttribute("errormsg", "登录失败，登录信息错误！");
				return ERROR;
			}

		} catch (Exception e) {
			e.printStackTrace();

		}

		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonObject.toString());
		return NONE;
	}

	public String admincheck() throws IOException {

		Map<String, String> map = new HashMap<String, String>();

		System.out.println("action--------admincheck()中获得的 账号=" + user.getUser_id());

		System.out.println("action中的try方法执行了...");

		// Boolean flag=userService.findByUser(user);

		try {
			User user4 = userService.findByUser2(user);
			System.out.println("------------user.getUser_role()=" + user.getUser_role());
			// String s=user4.getUser_role();
			// String role=user.getUser_role();
			if (user4 == null) {
				System.out.println("登录失败");
				map.put("msg", "登录失败,账号密码不正确");
				ServletActionContext.getRequest().getSession().setAttribute("errormsg", "登录失败，登录信息错误！");
				return ERROR;
			}
			System.out.println("-------------user.getUser_role()=" + user.getUser_role());
			if (user4 != null) {
				System.out.println("管理员登录成功");
				map.put("msg", "管理员登录成功");
				ServletActionContext.getRequest().getSession().setAttribute("user", user4);
				return "toindex";
			} /*
				 * else { System.out.println("登录失败"); map.put("msg",
				 * "登录失败,账号密码不正确");
				 * ServletActionContext.getRequest().getSession().setAttribute(
				 * "errormsg", "登录失败，登录信息错误！"); return ERROR; }
				 */

		} catch (Exception e) {
			e.printStackTrace();

		}

		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonObject.toString());
		return NONE;
	}

	public String register() throws IOException {
		System.out.println("action中的register方法执行了...");
		Map<String, String> map = new HashMap<String, String>();
		System.out.println("action--------register()中获得的 姓名=" + user.getUser_name());
		try {
			/* System.out.println("action中的try方法执行了..."); */
			String user_uuid = UUID.randomUUID().toString().replace("-", "");
			user.setUser_uuid(user_uuid);
			userService.save(user);
			int counts = userService.findCounts(user);
			System.out.println("=========================counts=" + counts);
			List<PersonCounts> list = personCountsService.findAllPersonCounts();
			PersonCounts p = new PersonCounts();
			for (PersonCounts personCounts : list) {
				System.out.println("PersonCountsAction-----方法查出来的数据PersonCounts=" + personCounts.getUser_counts());
				p = personCounts;
			}
			p.setUser_counts(String.valueOf(counts));
			personCountsService.updateUserCounts(p);
			map.put("msg", "注册成功,请登陆");
			User user2 = userService.findByUser2(user);
			String role = user.getUser_role();
			String s = "管理员";
			ServletActionContext.getRequest().getSession().setAttribute("user", user2);
			/*
			 * if(role==s) {
			 * 
			 * return "toindex"; }
			 */

			return "login";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("msg", "注册失败，请重新注册");
		}
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonObject.toString());
		return NONE;
	}

}
