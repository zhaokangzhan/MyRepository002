package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Testdao;
import com.domain.TestSelect;
import com.util.TestScore;;

/**
 * Servlet implementation class CheckServlet
 */
public class CheckServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ArrayList<Integer> ra_list = (ArrayList<Integer>) getServletContext().getAttribute("ra_list");
		System.out.println("------------------------当前位置checkservlet：");
		for (Integer integer : ra_list) {
			System.out.println("------------checkservler-------------抽取并且填写的题目id:"+integer);
		}
		
		
		//根据题目的id去查找数据库对应题号的答案
		ArrayList<String> list = new ArrayList<String>();
		Map<String, String[]> map = request.getParameterMap();
		
		Set<String> key = map.keySet();
		Iterator<String> iterator = key.iterator();
		ArrayList<String> valueStringList = new ArrayList<String>();
		while (iterator.hasNext()) {
			String keyString = (String) iterator.next();
			String[] value = map.get(keyString);
			for(int i = 0; i < value.length ; i++) {
				String valueString = value[i];
				valueStringList.add(valueString);
				System.out.println("------checkservlet------------学生答题的答案"+keyString+"==="+valueString);	
			}	
		}
		int getScore = TestScore.GetTestScore(map, list,ra_list);
		
		//分数
         request.getSession().setAttribute("getScore", getScore);
       //学生答题选项
     	ArrayList<String> correctanswer_list = Testdao.getInstance().getAnswerList(ra_list);
     	ArrayList<TestSelect> explain = Testdao.getInstance().getRealTest(ra_list);
     			request.getSession().setAttribute("xtest", valueStringList);
     			request.getSession().setAttribute("canswer",correctanswer_list);
     			request.getSession().setAttribute("explain",explain);
     			System.out.println("----checkservlet------xtest+canswer:"+valueStringList+correctanswer_list);
     			System.out.println("----checkservlet------explain:"+explain);
	request.getRequestDispatcher("textscore.jsp").forward(request, response);
		
	
	
	
			//正确答案
			
			//for (String cal : correctanswer_list) {
			//	System.out.println("----checkservlet---------数据库拿到的答案如下:"+cal);
		   // }
			//request.getSession().setAttribute("correctanswer_list",correctanswer_list);
	
	
		//PrintWriter pw = response.getWriter();
		//pw.write("----------submit seccess-----");
		//response.setHeader("Refresh", "2;URL=/MiddleSchoolWebsite/textscore.jsp");
		
		
	//response.getWriter().write("<script language='javascript'>alert('');window.location.href='textscore.jsp';</script>");
		System.out.println("本次测试得分:"+getScore);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
