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
import org.hibernate.criterion.Projections;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import domain.PersonCounts;
import domain.Teacher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import service.PersonCountsService;
import service.TeacherService;


public class PersonCountsAction extends ActionSupport {

private PersonCounts personCounts = new PersonCounts();
private  PersonCountsService personCountsService;	

	public PersonCounts getPersonCounts() {
	return personCounts;
}

public void setPersonCounts(PersonCounts personCounts) {
	this.personCounts = personCounts;
}



	public PersonCountsService getPersonCountsService() {
	return personCountsService;
}

public void setPersonCountsService(PersonCountsService personCountsService) {
	this.personCountsService = personCountsService;
}

private Teacher teacher = new Teacher();

public Teacher getTeacher() {
	return teacher;
}

public void setTeacher(Teacher teacher) {
	this.teacher = teacher;
}
//注入Service
	private TeacherService teacherService;

	public TeacherService getTeacherService() {
		return teacherService;
	}

	public void setTeacherService(TeacherService teacherService) {
		this.teacherService = teacherService;
	}
	public String personCounts() throws IOException{
		 
		/*String sql1="select count(*) from teacher";
		String sql2="select count(*) from student";
		int count1=findCounts(sql1);
		
		int count2=findCounts(sql2);*/
	

		System.out.println("=====findcounts方法执行啦" );
		/*DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Teacher.class);		
		detachedCriteria.setProjection(Projections.rowCount());
		 int count1=teacherService.findCounts(detachedCriteria);
			System.out.println("=====count1="+count1 );*/
		
		List<PersonCounts> list=personCountsService.findAllPersonCounts(personCounts);
		String [] counts=null;
		PersonCounts p = new PersonCounts();
		for(PersonCounts personCounts:list){
			System.out.println("=====personCounts获得数据记录personCounts.getTeacher_counts()="+personCounts.getTeacher_counts() );
			/*int count1=Integer.parseInt(personCounts.getTeacher_counts());
			int count2=Integer.parseInt((personCounts.getStudent_counts()));*/
		
			/*String[] irray=new String[count1,count2];*/
			p=personCounts;
		}
		 
		 String count1=p.getStudent_counts();
		 String count2=p.getTeacher_counts();
		 String count3=p.getDean_counts();
		 String count4=p.getUser_counts();
		 String count5=p.getOther_counts();
			String countadd=count1+","+count2+","+count3+","+count4+","+count5;
			System.out.println("counts="+countadd);
			 counts= countadd.split(","); 
			
			System.out.println("countadd.split(',')----------counts="+counts);
			System.out.println("------------------------counts[0]="+counts[0]);
			System.out.println("------------------------counts[1]="+counts[1]);
	
		System.out.println("循环外的counts="+counts);
		/*int counts=personCountsService.findPersonCounts(personCounts);*/
		
		/*JSONObject jsonObject = JSONObject.fromObject(counts);*/
		JSONArray jsonArray=JSONArray.fromObject(counts);
		System.out.println("=====findcounts获得数据记录counts="+counts );
		// ServletActionContext.getRequest().getSession().setAttribute("authority",
		// authority);
		
		System.out.println("jsonArray="+jsonArray);
		System.out.println("jsonArray.toString()="+jsonArray.toString());
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		
		ServletActionContext.getResponse().getWriter().print(jsonArray);//

		return NONE;
	}
}
