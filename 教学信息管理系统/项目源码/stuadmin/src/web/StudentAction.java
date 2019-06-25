package web;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.PageBean;
import domain.PersonCounts;
import domain.Student;
import domain.Teacher;
import net.sf.json.JSONObject;
import service.PersonCountsService;
import service.StudentService;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {

	// 模型驱动使用的对象
	private Student student = new Student();

	@Override
	public Student getModel() {
		return student;
	}

	// 注入Service
	private StudentService studentService;

	public StudentService getStudentService() {
		return studentService;
	}

	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}
private PersonCountsService personCountsService;
	
	
	public PersonCountsService getPersonCountsService() {
		return personCountsService;
	}

	public void setPersonCountsService(PersonCountsService personCountsService) {
		this.personCountsService = personCountsService;
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
	
	public String student() throws IOException {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Student.class);
		// 调用业务层:
		PageBean<Student> pageBean = studentService.findByPage(detachedCriteria,page,rows);
		// 使用jsonlib或者fastjson
		Map<String,Object> map = new HashMap<String,Object>();
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

		System.out.println("action--------save()中获得的 姓名=" + student.getStudent_name());
		try {
			System.out.println("action中的try方法执行了...");
			String student_uuid = UUID.randomUUID().toString().replace("-", "");
			student.setStudent_uuid(student_uuid);;
			studentService.save(student);
			
			

			int counts=studentService.findCounts(student);
			System.out.println("=========================counts="+counts);
			List<PersonCounts>  list=personCountsService.findAllPersonCounts();
			
			PersonCounts p = new PersonCounts();
			for (PersonCounts personCounts : list) {
				System.out.println("PersonCountsAction-----方法查出来的数据PersonCounts=" + personCounts.getStudent_counts());
				p=personCounts;
			}
			
			p.setStudent_counts(String.valueOf(counts));
			
		System.out.println("循环后数据-----p.getStudent_counts()="+p.getStudent_counts());
			
			personCountsService.updateStudentCounts(p);
			
			
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
	public String edit() throws IOException {

		String id = ServletActionContext.getRequest().getParameter("id");

		student = studentService.findBySelectId(id);

		System.out.println("编辑=====查出来的激活状态:" + student.getStudent_active());

		JSONObject jsonObject = JSONObject.fromObject(student);
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
			studentService.update(student);
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
	
	public String delete() throws IOException {
		Map<String, String> map = new HashMap<String, String>();
		String ids = ServletActionContext.getRequest().getParameter("ids");
		String[] arr = ids.split(",");
		try {

			List<Student> list = studentService.findById(arr);
			for (Student student : list) {
				System.out.println("studentAction-----delete方法查出来的数据------姓名:" + student.getStudent_name());
			}
			studentService.delete(list);

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
}
