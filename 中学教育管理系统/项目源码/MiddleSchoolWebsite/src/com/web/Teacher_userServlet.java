package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.domain.student_User;
import com.domain.teacher_User;
import com.service.Student_UserService;
import com.service.Teacher_UserService;

/**
 * Servlet implementation class Teacher_userServlet
 */
public class Teacher_userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Teacher_userServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		int method=Integer.parseInt(request.getParameter("method"));
	System.out.println("---------Student_userServlet--------mothod="+method);

	
		switch (method) {	
		case 1:{
			
				try {
					this.listall_user(request,response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		
			break;
		}
	
	
				
		default:
			break;
		}
		
	}



	
	
	private void listall_user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
	
		// 1.创建service层的对象
		Teacher_UserService service = new Teacher_UserService();
				// 2.调用service层用于查询所有商品的方法
				List<teacher_User> sus = service.listallteacher_users();
				//分页
				if(sus==null) {
					sus=new ArrayList<teacher_User>();
				}
				int recordCount=sus.size();//记录条数
				int maxPage=recordCount;//页数
				int number;   //第几页
				if(maxPage%5==0) {
					maxPage=maxPage/10;
				}else {
					maxPage=maxPage/10+1;
				}
				//第几页
				if(request.getParameter("i")==null) {
					number=1;
				}else {
					number=Integer.parseInt(request.getParameter("i"));
				}
				int start=(number-1)*10;
				int over=number*10-1;
				if(recordCount<=over) {
					over=recordCount;	
				}
				request.setAttribute("start", start);
				request.setAttribute("over", over);
				request.setAttribute("number", number);
				request.setAttribute("maxPage", maxPage);
				request.setAttribute("recordCount", recordCount);
				// 3.将查询出的所有商品放进request域中
				request.setAttribute("sus", sus);
				
				// 4.重定向到list.jsp页面
				request.getRequestDispatcher("/teacher_admin.jsp").forward(
						request, response);
	}		
}
