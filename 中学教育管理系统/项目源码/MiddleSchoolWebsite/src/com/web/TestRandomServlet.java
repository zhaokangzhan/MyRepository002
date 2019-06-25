package com.web;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.dao.Testdao;
import com.domain.TestSelect;


/**
 * Servlet implementation class TestFormServlet
 */
public class TestRandomServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		
		//获取数据库的题目总数
		System.out.println("------------------------当前位置TestRa：");
		int totalCount = Testdao.getInstance().getTotal();
		// 注意=====数据库里面的总题目数必须大于等于抽取考试题目的数量
		// 在数据库题目的总条数范围内生成4个随机数，随机作为被抽到的题目的ID值，作为别抽到题目的唯一值
		ArrayList<Integer> ra_list = new ArrayList<Integer>();
		while (ra_list.size()<5) {
			Random ra = new Random();
			int ra_id = ra.nextInt(totalCount) + 1;
			//用集合去存储不相同随机数------避免生成了相同的随机数
			if (!ra_list.contains(ra_id)) {
				ra_list.add(ra_id);
			}
		}	
		//将 ra_list存起来，作为查被抽到的题目的答案的函数参数
		getServletContext().setAttribute("ra_list", ra_list);
		
		ArrayList<TestSelect> lasttests = Testdao.getInstance().getRealTest(ra_list);
		
		request.getSession().setAttribute("lasttests", lasttests);
		request.getRequestDispatcher("test.jsp").forward(request, response);
		System.out.println("hhhhhhh集合长度:"+lasttests.size());
		for (TestSelect testselect : lasttests) {
			System.out.println("随机抽到题目的信息如下：");
			System.out.println("题号:"+testselect.getId()+"题目信息："+testselect.getQuestion()+"答案"+testselect.getAnser());
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
