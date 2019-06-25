package web;

import java.io.IOException;
import java.sql.Array;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.apache.logging.log4j.core.util.UuidUtil;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.PageBean;
import domain.Score;
import domain.Test;
import domain.User;
import net.sf.json.JSONObject;
import service.ScoreService;
import service.TestService;

public class TestAction extends ActionSupport implements ModelDriven<Test> {

	// 模型驱动使用的对象
	private Test test = new Test();

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	@Override
	public Test getModel() {
		return test;
	}

	// 注入Service
	private TestService testService;

	public TestService getTestService() {
		return testService;
	}

	public void setTestService(TestService testService) {
		this.testService = testService;
	}

	private ScoreService scoreService;
	
	public ScoreService getScoreService() {
		return scoreService;
	}

	public void setScoreService(ScoreService scoreService) {
		this.scoreService = scoreService;
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

	public String test() throws IOException {
		System.out.println("action中的Test()方法执行了...");
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Test.class);
		// 调用业务层:
		PageBean<Test> pageBean = testService.findByPage(detachedCriteria, page, rows);
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

		System.out.println("action--------save()中获得的 answer=" + test.getTest_answer());
		try {
			System.out.println("action中的try方法执行了...");
			String test_uuid = UUID.randomUUID().toString().replace("-", "");
			test.setTest_uuid(test_uuid);
			testService.save(test);

			int counts = testService.findCounts(test);
			System.out.println("=========================counts=" + counts);

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

			List<Test> list = testService.findById(arr);
			for (Test test : list) {
				System.out.println("TestAction-----delete方法查出来的数据------" + test);
			}
			testService.delete(list);

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

		test = testService.findBySelectId(id);

		System.out.println("编辑=====查出来的-----");

		JSONObject jsonObject = JSONObject.fromObject(test);
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
			testService.update(test);
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

		System.out.println("=====findcounts方法执行啦");
		int counts = testService.findCounts(test);
		JSONObject jsonObject = JSONObject.fromObject(counts);
		System.out.println("=====findcounts获得数据记录counts=" + counts);
		// ServletActionContext.getRequest().getSession().setAttribute("authority",
		// authority);

		System.out.println("counts=" + counts);
		System.out.println("jsonObject.toString()" + jsonObject.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");

		ServletActionContext.getResponse().getWriter().println(jsonObject);//
		// {"msg":..}
		return NONE;
	}

	public String testList() throws IOException {
		System.out.println("action中的Test()方法执行了...");
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Test.class);
		// 调用业务层:
		PageBean<Test> pageBean = testService.findByPage(detachedCriteria, page, rows);
		// 使用jsonlib或者fastjson

		System.out.println("======================" + pageBean.getList().size());
		// Map<String, Object> map = new HashMap<String, Object>();
		// map.put("total", pageBean.getTotalCount());
		// map.put("rows", pageBean.getList());
		/*
		 * int total=pageBean.getTotalCount(); List<Test>
		 * list=pageBean.getList();
		 */

		int counts = testService.findCounts(test);
		List<Test> lst = testService.getRandomTestList();
		// List<questioninfo> lst = readallquestion(strPath);//文件中所有的题的集合
		int randomcounts = 12;
		if (randomcounts < counts) {
			counts = randomcounts;
		} else {
			randomcounts = counts - 1;
		}
		int r = (int) (Math.random() * lst.size());
		Set<Integer> set = new HashSet<Integer>();
		while (set.size() < randomcounts) {
			set.add(r);
			r = (int) (Math.random() * lst.size());// 再次随机,如果随机数重复，集合中的size()不变
		}
		List<Test> lstpro = new ArrayList<Test>();// 提供的题的集合
		for (Integer ii : set) {
			{
				Test q = lst.get(ii);
				lstpro.add(q);
			}
		}
		// request.setAttribute("question", lstpro);

		ServletActionContext.getRequest().getSession().setAttribute("total", counts);
		ServletActionContext.getRequest().getSession().setAttribute("list", lstpro);

		/*
		 * // JSONArray,JSONObject JSONObject jsonObject =
		 * JSONObject.fromObject(map);
		 * ServletActionContext.getResponse().setContentType(
		 * "text/html;charset=UTF-8");
		 * ServletActionContext.getResponse().getWriter().println(jsonObject.
		 * toString());
		 */
		return "tophysics";

	}

	public String checkAnswer() throws IOException {
		// ServletActionContext.getAttribute("list");
		System.out.println("checkAnswer()执行啦");
		// 正确答案
		List listanswer = new ArrayList();
		List<Test> list = (List<Test>) ServletActionContext.getRequest().getSession().getAttribute("list");
		for (Test test : list) {
			System.out.println("--------getTest_answer()=" + test.getTest_answer());
			listanswer.add(test.getTest_answer());
			System.out.println("--------listanswer=" + listanswer);
		}
		ServletActionContext.getRequest().getSession().setAttribute("listanswer", listanswer);

		// 提交选项
		Map<String, String[]> map = ServletActionContext.getRequest().getParameterMap();
		//LinkedHashMap<String, String> map = ServletActionContext.getRequest().getParameterMap();
		System.out.println("----------map=" + map);
		String smap=map.toString();
		System.out.println("smap="+smap);
		Set<String> key = map.keySet();
		
		System.out.println("----------map.keySet()=" + map.keySet());
		Iterator<String> iterator = key.iterator();		
		ArrayList<String> keyStringList = new ArrayList<String>();
		ArrayList<String> valueStringList = new ArrayList<String>();
		System.out.println("--------------------------------学生答题的选项");

		/*// 分数分配
		int testscore = 0;
		int questionNum = listanswer.size();
		int allScore = 100;
		String eachscore = "";
		float num = (float) allScore / questionNum;
		DecimalFormat df = new DecimalFormat("0.0");
		eachscore = df.format(num);
		int es = Integer.parseInt(eachscore);
		System.out.println("每道题得分=" + es);*/
		int testscore = 0;
		int questionNum = listanswer.size();
		int allScore = 100;
		int es= allScore / questionNum;
		//int es=(int)(eachscore);
		System.out.println("每道题得分=" + es);
		while (iterator.hasNext()) {
			String keyString = (String) iterator.next();
			String[] value = map.get(keyString);
				for (int i = 0; i < value.length; i++) {
				String valueString = value[i];	
				System.out.println("valueString="+valueString);
				keyStringList.add(keyString);
				valueStringList.add(valueString);
				
				System.out.println("------checkservlet------------学生答题的选项" + keyString + "===" + valueString);

				if (listanswer.get(i).equals(valueString)) {
					testscore = testscore + es;// 设置分值
				} 
				
			}
		}
	
		/*根据登录用户测试成绩插入分数表*/
		User user=(User) ServletActionContext.getRequest().getSession().getAttribute("user");
		System.out.println("========================TestAction中的user.getUser_id()="+user.getUser_id());
		System.out.println("========================TestAction中的user.getUser_name()="+user.getUser_name());		
		Score score=new Score();
		String ts=String.valueOf(testscore);		
		String suuid = UUID.randomUUID().toString().replace("-", "");
		String sid=user.getUser_id();	
		score.setScore_uuid(suuid);	
		score.setScore_id(sid);
        score.setUser_id(user.getUser_id()); 
	    score.setUser_name(user.getUser_name()); 
	    score.setCourse_name("物理");
	    score.setScore(ts);
	    score.setScore_active("有效");
	    /*查是否已测过*/
	    String fs=user.getUser_id();  		
	    DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Score.class);
	    List<Score> scs=scoreService.findByScore(detachedCriteria);
	    for (Score score2 : scs) {
	    	System.out.println("score2.getUser_id()="+score2.getUser_id());
			if(score2.getUser_id()==fs) {
				Score score3=score;
				 scoreService.updateScoreAfterTest(score3);
				return "totestscore";
			}
		}
		
	    
	    System.out.println("-----------循环外");
	   
					scoreService.saveScoreAfterTest(score);
			
		ServletActionContext.getRequest().getSession().setAttribute("keyStringList", keyStringList);		
		ServletActionContext.getRequest().getSession().setAttribute("valueStringList", valueStringList);
		//testscore=Math.ceil(testscore);
	//	testscore=(int)testscore;
			ServletActionContext.getRequest().getSession().setAttribute("testscore", testscore);
		System.out.println("得分=" + testscore);
		

		return "totestscore";

	}
}
