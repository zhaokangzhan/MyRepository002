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

import domain.Authority;
import domain.PageBean;

import net.sf.json.JSONObject;
import service.AuthorityService;
import service.Impl.AuthorityServiceImpl;

public class AuthorityAction extends ActionSupport implements ModelDriven<Authority> {

	// 模型驱动使用的对象
	private Authority authority = new Authority();

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public Authority getAuthority() {
		return authority;
	}

	@Override
	public Authority getModel() {
		return authority;
	}

	// 注入Service
	private AuthorityService authorityService;

	public AuthorityService getAuthorityService() {
		return authorityService;
	}

	public void setAuthorityService(AuthorityServiceImpl authorityService) {
		this.authorityService = authorityService;
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

	public String authority() throws IOException {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Authority.class);
		// 调用业务层:
		PageBean<Authority> pageBean = authorityService.findByPage(detachedCriteria, page, rows);
		// 使用jsonlib或者fastjson
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

		System.out.println("action中获得的authority角色=" + authority.getRole());
		try {
			System.out.println("action中的try方法执行了...");
			String uuid = UUID.randomUUID().toString().replace("-", "");
			authority.setUuid(uuid);
			authorityService.save(authority);
			map.put("msg", "保存成功");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			map.put("msg", "保存失败");
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

			List<Authority> list = authorityService.findById(arr);
			for (Authority authority : list) {
				System.out.println("查出来的数据:" + authority.getActive());
			}
			authorityService.delete(list);

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

		authority = authorityService.findBySelectId(id);

		System.out.println("编辑=====查出来的激活状态:" + authority.getActive());

		JSONObject jsonObject = JSONObject.fromObject(authority);
		//ServletActionContext.getRequest().getSession().setAttribute("authority", authority);
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
			authorityService.update(authority);
			map.put("msg", "保存成功!");
		} catch (Exception e) {
			e.printStackTrace();
			map.put("msg", "保存失败!");
		}
		// 将map转成JSON:
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println(jsonObject.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().println(jsonObject.toString());// {"msg":..}

		return NONE;
	}
}
