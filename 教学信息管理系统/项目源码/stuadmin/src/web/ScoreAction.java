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
import net.sf.json.JSONObject;

import service.ScoreService;

public class ScoreAction extends ActionSupport implements ModelDriven<Score> {

	// 模型驱动使用的对象
	private Score score = new Score();

	public Score getScore() {
		return score;
	}

	public void setScore(Score score) {
		this.score = score;
	}

	@Override
	public Score getModel() {
		return score;
	}

	// 注入Service
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

	public String score() throws IOException {
		System.out.println("action中的Score()方法执行了...");
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Score.class);
		// 调用业务层:
		PageBean<Score> pageBean = scoreService.findByPage(detachedCriteria, page, rows);
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

		System.out.println("action--------save()中" );
		try {
			System.out.println("action中的try方法执行了...");
			String score_uuid = UUID.randomUUID().toString().replace("-", "");
			score.setScore_uuid(score_uuid);
			scoreService.save(score);

			int counts = scoreService.findCounts(score);
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

			List<Score> list = scoreService.findById(arr);
			for (Score Score : list) {
				System.out.println("ScoreAction-----delete方法查出来的数据------" + Score);
			}
			scoreService.delete(list);

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

		score = scoreService.findBySelectId(id);

		System.out.println("编辑=====查出来的-----");

		JSONObject jsonObject = JSONObject.fromObject(score);
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
			scoreService.update(score);
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
		int counts = scoreService.findCounts(score);
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

	public String charts() throws IOException {
		System.out.println("action中的charts()方法执行了...");
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Score.class);
		// 调用业务层:
		List<Score> score = scoreService.findByScore(detachedCriteria);
		List<Score> alist=new ArrayList<>();
		List<Score> blist=new ArrayList<>();
		List<Score> clist=new ArrayList<>();
		List<Score> dlist=new ArrayList<>();
		List<Score> elist=new ArrayList<>();
		List<Score> flist=new ArrayList<>();
		List<Score> glist=new ArrayList<>();
		List<String> dscore=new ArrayList<>();
	    int sum=score.size();
		for(Score sc:score){
			String s=sc.getScore();
		      int ints=Integer.parseInt(s);
		      if (0<=ints&&ints<50) {
		    	  alist.add(sc);
			} else if(50<=ints&&ints<60){
				 blist.add(sc);
			} else if(60<=ints&&ints<70){
				 clist.add(sc);
			} else if(70<=ints&&ints<80){
				 dlist.add(sc);
			} else if(80<=ints&&ints<90){
				 elist.add(sc);
			} else if(90<=ints&&ints<=100){
				 flist.add(sc);
			}else {
				 glist.add(sc);
			}
			System.out.println("--------------------分数："+sc.getScore());
		}		
		int a=alist.size();
		int b=blist.size();
		int c=clist.size();
		int d=dlist.size();
		int e=elist.size();
		int f=flist.size();
		int g=glist.size();
		System.out.println("--------------------分数段a的人数："+a);
		System.out.println("--------------------分数段b的人数："+b);
		System.out.println("--------------------分数段c的人数："+c);
		System.out.println("--------------------分数段d的人数："+d);
		System.out.println("--------------------分数段e的人数："+e);
		System.out.println("--------------------分数段f的人数："+f);
		System.out.println("--------------------分数段g的人数："+g);
		System.out.println("迭代循环前dscore.size()="+dscore.size());

		dscore.add(String.valueOf(a));
		dscore.add(String.valueOf(b));
		dscore.add(String.valueOf(c));
		dscore.add(String.valueOf(d));
		dscore.add(String.valueOf(e));
		dscore.add(String.valueOf(f));
		dscore.add(String.valueOf(g));
		ServletActionContext.getRequest().getSession().setAttribute("a", a);				
	ServletActionContext.getRequest().getSession().setAttribute("dscore", dscore);		
	
		return "touser_test";

	}

	
}
