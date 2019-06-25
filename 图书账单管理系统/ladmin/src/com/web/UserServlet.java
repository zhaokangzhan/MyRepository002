package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.BooksDao;
import com.dao.UsersDao;
import com.domain.Book;
import com.domain.User;

/**
 * Servlet implementation class UserServlet
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
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
	
		switch (method) {
		case 0:{
			this.insertone_user(request,response);
			break;
		}
		case 1:{
			this.listall_user(request,response);
			break;
		}
		case 2:{
			this.searchone_user(request,response);
			break;
		}
		case 3:{
			this.deleteone_user(request,response);
			break;
		}
		case 4:{
			this.selectone_user(request,response);
			break;
		}
		case 5:{
			this.updateone_user(request,response);
			break;
		}
		case 6:{
			this.registerone_user(request,response);
			break;
		}
		default:
			break;
		}
	}

	private void registerone_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phonenumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String checkCode = request.getParameter("check_code");
		String savedCode = (String) request.getSession().getAttribute(
				"check_code");
       PrintWriter pw = response.getWriter();
       
       System.out.println("userservelet的用户名:"+username);
       System.out.println("userservelet的密码:"+password);
		if(username==null||password==null) {
		
			pw.print("<script language=javascript>alert(`添加用户失败，请重新填写`);window.location.href=`register.jsp`</script>");
			
		}else {
       
		
			User user=new User();  
			user.setUsername(username);
			user.setPassword(password);
			user.setPhonenumber(phonenumber);
			user.setEmail(email);;
			Boolean flag=UsersDao.getInstance().insertuser(user);
		
			//pw.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;注  &nbsp;&nbsp;册   &nbsp;成  &nbsp;功"
				//	+ "&nbsp;现&nbsp;在&nbsp;可&nbsp;以&nbsp;登&nbsp;陆&nbsp;啦           ");
			//response.setHeader("Refresh", "2;URL=/StyleMall/login.jsp");
			pw.print("<script language=javascript>alert(`添加用户成功,登陆即可操作数据`);window.location.href=`login.jsp`</script>");
		}
	}

	private void updateone_user(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String useridd= request.getParameter("idd" );
		//String userid= request.getParameter("userid" );
		String username = request.getParameter("username");
		String password= request.getParameter("password");
		String phonenumber = request.getParameter("phonenumber");
		String email= request.getParameter("email");
		 System.out.println("传过来的1---------------------useridd="+useridd);
		 System.out.println("传过来的1---------------------username="+username);
		
        if(useridd!=null&& !useridd.equals("")) {
        	int id=Integer.valueOf(useridd ); 
        	 System.out.println("传过来的idd后结果2---------------------userid="+id);
        	User user=new User();
                user.setId(id);
       	 System.out.println("userservlet修改的-----------------------user.getid()="+user.getId());
        	user.setUsername(username);
        	user.setPassword(password);
        	user.setPhonenumber(phonenumber);
        	user.setEmail(email);
        	
    		 System.out.println("userservlet修改的user.getusername()="+user.getUsername());
			
        User rc=UsersDao.getInstance().updateone_user(user);
        
       
        	 System.out.println("成功");
        	
        	
        	 PrintWriter pw = response.getWriter();
        	 pw.print("<script language=javascript>alert(`修改选中用户成功 `);window.location.href=`UserServlet?method=1`</script>");
         	
 			 System.out.println("成功");
 		
        
        }else {
        	
        	 System.out.println("修改失败");
        	RequestDispatcher rd=request.getRequestDispatcher("userUpdate.jsp");
    		rd.forward(request, response);	
        }
       
	}

	private String selectone_user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter( "id" );
        if(idStr !=null&& !idStr.equals("")) {
        	int id=Integer.valueOf(idStr);       
		System.out.println("id="+id);
	 
		User user=UsersDao.getInstance().selectoneuser(id);
		 
		     System.out.println("userservlet的user.getId()="+user.getId());
		     System.out.println("userservlet的user.getuserid()="+ user.getUsername());
		while(user!=null) {
	
		request.setAttribute("ruser",user);
		RequestDispatcher rd=request.getRequestDispatcher("userUpdate.jsp");
		rd.forward(request, response);
		}
		
        }
		else {
			
			  System.out.println("userservlet查询当前id结果失败");			
		}
		return null;
		
	}

	private void deleteone_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String idStr = request.getParameter( "id" );
        if(idStr !=null&& !idStr.equals("")) {
        	int id=Integer.valueOf(idStr); 
        
		System.out.println("id="+id);
	   
	int rid=UsersDao.getInstance().deleteone_user(id);
	
	if(rid!=0) {
		
		pw.print("<script language=javascript>alert(`删除选中用户成功 `);window.location.href=`UserServlet?method=1`</script>");
		
		
			
	}
	
        }else {
        	
        	pw.print("<script language=javascript>alert(`删除选中用户失败 `);window.location.href=`UserServlet?method=1`</script>");
        	
		}
	}

	private void searchone_user(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	private void listall_user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<User> allusers=(ArrayList<User>)UsersDao.getInstance().selectallusers();
		if(allusers==null) {
			allusers=new ArrayList<User>();
		}
		int recordCount=allusers.size();//记录条数
		int maxPage=recordCount;//页数
		int number;   //第几页
		if(maxPage%5==0) {
			maxPage=maxPage/5;
		}else {
			maxPage=maxPage/5+1;
		}
		
		if(request.getParameter("i")==null) {
			number=1;
		}else {
			number=Integer.parseInt(request.getParameter("i"));
		}
		
		int start=(number-1)*5;
		int over=number*5-1;
		if(recordCount<=over) {
			over=recordCount;	
		}
		request.setAttribute("start", start);
		request.setAttribute("over", over);
		request.setAttribute("number", number);
		request.setAttribute("maxPage", maxPage);
		request.setAttribute("recordCount", recordCount);
		
		HttpSession session=request.getSession();
		session.setAttribute("allusers", allusers);
		request.setAttribute("rallusers",allusers);
		
	RequestDispatcher rd=request.getRequestDispatcher("userList.jsp");
	rd.forward(request, response);
	}

	private void insertone_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String phonenumber = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String checkCode = request.getParameter("check_code");
		String savedCode = (String) request.getSession().getAttribute(
				"check_code");
       PrintWriter pw = response.getWriter();
       
       System.out.println("userservelet的用户名:"+username);
       System.out.println("userservelet的密码:"+password);
		if(username.isEmpty()||password.isEmpty()) {
		
			pw.print("<script language=javascript>alert(`信息有误，添加用户失败，请重新填写`);window.location.href=`userAdd.jsp`</script>");
		}else {
       
		
			User user=new User();  
			user.setUsername(username);
			user.setPassword(password);
			user.setPhonenumber(phonenumber);
			user.setEmail(email);;
			Boolean flag=UsersDao.getInstance().insertuser(user);
		
			//pw.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;注  &nbsp;&nbsp;册   &nbsp;成  &nbsp;功"
				//	+ "&nbsp;现&nbsp;在&nbsp;可&nbsp;以&nbsp;登&nbsp;陆&nbsp;啦           ");
			//response.setHeader("Refresh", "2;URL=/StyleMall/login.jsp");
			pw.print("<script language=javascript>alert(`添加用户成功`);window.location.href=`UserServlet?method=1`</script>");
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
