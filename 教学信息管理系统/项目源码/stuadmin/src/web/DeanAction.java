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

import domain.Dean;
import domain.PageBean;
import domain.PersonCounts;
import domain.Teacher;
import net.sf.json.JSONObject;
import service.DeanService;
import service.PersonCountsService;
import service.TeacherService;

public class DeanAction extends ActionSupport implements ModelDriven<Dean> {

	// 模型驱动使用的对象
	private Dean dean = new Dean();

	private PersonCountsService personCountsService;
	private DeanService deanService;
	
	public Dean getDean() {
		return dean;
	}

	public void setDean(Dean dean) {
		this.dean = dean;
	}

	public PersonCountsService getPersonCountsService() {
		return personCountsService;
	}

	public void setPersonCountsService(PersonCountsService personCountsService) {
		this.personCountsService = personCountsService;
	}

	public DeanService getDeanService() {
		return deanService;
	}

	public void setDeanService(DeanService deanService) {
		this.deanService = deanService;
	}

	public Integer getPage() {
		return page;
	}

	public Integer getRows() {
		return rows;
	}

	@Override
	public Dean getModel() {
		return dean;
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

	public String dean() throws IOException {
		System.out.println("action中的dean()方法执行了...");
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Dean.class);
		// 调用业务层:
		PageBean<Dean> pageBean = deanService.findByPage(detachedCriteria, page, rows);
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

		System.out.println("action--------save()中获得的 姓名=" + dean.getDean_name());
		try {
			System.out.println("action中的try方法执行了...");
			String dean_uuid = UUID.randomUUID().toString().replace("-", "");
			dean.setDean_uuid(dean_uuid);
			deanService.save(dean);
			
			int counts=deanService.findCounts(dean);
			System.out.println("=========================counts="+counts);
			List<PersonCounts>  list=personCountsService.findAllPersonCounts();
			
			PersonCounts p = new PersonCounts();
			for (PersonCounts personCounts : list) {
				System.out.println("PersonCountsAction-----方法查出来的数据PersonCounts=" + personCounts.getTeacher_counts());
				p=personCounts;
			}
			
			p.setTeacher_counts(String.valueOf(counts));
			
		
			
			personCountsService.updateTeacherCounts(p);
			
			
			
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

			List<Dean> list = deanService.findById(arr);
			for (Dean dean : list) {
				System.out.println("TeacherAction-----delete方法查出来的数据------教师姓名:" + dean.getDean_name());
			}
			deanService.delete(list);

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

		dean = deanService.findBySelectId(id);

		System.out.println("编辑=====查出来的激活状态:" + dean.getDean_active());

		JSONObject jsonObject = JSONObject.fromObject(dean);
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
			deanService.update(dean);
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
	
	public String findcounts() throws IOException {

		

		System.out.println("=====findcounts方法执行啦" );
      int counts=deanService.findCounts(dean);
		JSONObject jsonObject = JSONObject.fromObject(counts);
		System.out.println("=====findcounts获得数据记录counts="+counts );
		// ServletActionContext.getRequest().getSession().setAttribute("authority",
		// authority);
		
		System.out.println("counts="+counts);
		System.out.println("jsonObject.toString()"+jsonObject.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		
		ServletActionContext.getResponse().getWriter().println(jsonObject);//
		// {"msg":..}
		return NONE;
	}
}
