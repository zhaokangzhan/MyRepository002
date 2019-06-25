package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UsersDao;
import com.domain.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
	response.setContentType("text/html;charset=utf-8");
	response.setCharacterEncoding("utf-8");
	request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String checkCode = request.getParameter("check_code");
		String savedCode = (String) request.getSession().getAttribute(
				"check_code");
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);	
		PrintWriter pw = response.getWriter();
		
		String username1 = URLEncoder.encode(username, "utf-8");      
		String id=UsersDao.getInstance().checkuser(user);
		System.out.println("loginservlet用户名："+username);
      if (id!=null) {
		
		
			HttpSession session=request.getSession();
			session.setAttribute("suser", username);
				MySessionListener mylistenuser=new MySessionListener();
				session.setAttribute("mylistenuseronline", mylistenuser);
			
				response.setHeader("Refresh", "2;URL=/ladmin/index.jsp");
				System.out.println("成功登陆的id为"+id);
			
			
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
