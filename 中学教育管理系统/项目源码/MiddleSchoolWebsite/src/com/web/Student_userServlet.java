package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dao.Student_Userdao;
import com.domain.student_User;
import com.service.Student_UserService;

/**
 * Servlet implementation class Student_userServlet
 */
public class Student_userServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Student_userServlet() {
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
		case 2:{
			this.update_onestudent_user(request,response);
			break;
		}
		case 3:{
			this.copyonestudent_user(request,response);
			break;
		}
		case 4:{
			this.realupdate_onestudent_user(request,response);
			break;
		}
		
		case 5:{
			this.add_onestudent_user(request,response);
			break;
		}
		
		case 6:{
			this.delete_onestudent_user(request,response);
			break;
		}
		case 7:{
			this.seach_onestudent_user(request,response);
			break;
		}
		case 8:{
			this.register_onestudent_user(request,response);
			break;
		}
		case 9:{
			this.logincheck_onestudent_user(request,response);
			break;
		}
		default:
			break;
		}
		
	}

	


	private void logincheck_onestudent_user(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		// TODO Auto-generated method stub
		String name=request.getParameter("username");
		String password=request.getParameter("password");
		
		Student_UserService service = new Student_UserService();
	 	 PrintWriter pw = response.getWriter();
		// 2.调用service层用于查询所有商品的方法
    	student_User su=new student_User();   
    	su.setName(name);
    	su.setPassword(password);
    	String id = service.logincheck_onestudent_user(su);
    	 if(id!=null) {
		//pw.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;注  &nbsp;&nbsp;册   &nbsp;成  &nbsp;功"
			//	+ "&nbsp;现&nbsp;在&nbsp;可&nbsp;以&nbsp;登&nbsp;陆&nbsp;啦           ");
		//response.setHeader("Refresh", "2;URL=/StyleMall/login.jsp");  
    		 System.out.println("------------------这里是if（）-----");
 			HttpSession session=request.getSession();
 			session.setAttribute("username", name); 
 			request.getRequestDispatcher("/index.jsp").forward(
 					request, response);
 			
	}else {
    	 pw.print("<script language=javascript>alert(`你尚未注册,请先注册`);window.location.href=`register.jsp`</script>");
		}	
		
		
	}

	private void register_onestudent_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String unique=request.getParameter("unique_id");
		System.out.println("============="+unique);
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String msex=request.getParameter("msex");
		String idcard=request.getParameter("idcard");
		String phonenumber=request.getParameter("phonenumber");
		System.out.println("phonenumber"+phonenumber);
		System.out.println(msex);	
		System.out.println("-----Student_userServlet--add_onestudent_user()---"
				+ "--unique---password"+unique+"---"+password);		
		Student_UserService service = new Student_UserService();
	 	 PrintWriter pw = response.getWriter();
		// 2.调用service层用于查询所有商品的方法
		if(name==null||password==null||name==""||password==""||msex==null) {
			
	pw.print("<script language=javascript>alert(`填写信息有误，请重新填写`);window.location.href=`register.jsp`</script>");
			
		}else {
    	student_User su=new student_User();   
    	su.setUnique_id(unique);
    	su.setName(name);
    	su.setPassword(password);
    	su.setSex(msex);
    	su.setIdcard_number(idcard);
    	su.setPhonenumber(phonenumber);
    	Boolean flag = service.add_onestudent_user(su);

		//pw.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;注  &nbsp;&nbsp;册   &nbsp;成  &nbsp;功"
			//	+ "&nbsp;现&nbsp;在&nbsp;可&nbsp;以&nbsp;登&nbsp;陆&nbsp;啦           ");
		//response.setHeader("Refresh", "2;URL=/StyleMall/login.jsp");
		pw.print("<script language=javascript>alert(`注册成功,请登录`);window.location.href=`login.jsp`</script>");
	}
	}

	private void seach_onestudent_user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String unique=request.getParameter("unique");		
		Student_UserService service = new Student_UserService();
		List<student_User> sus = service.seach_onestudent_user(unique);
		
		  	
		if(sus==null) {
			sus=new ArrayList<student_User>();
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
		request.setAttribute("unique", unique);
		
		// 4.重定向到list.jsp页面
		request.getRequestDispatcher("/seach_student.jsp").forward(
				request, response);
		
		
	}

	private void delete_onestudent_user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter( "id" );
		System.out.println("-删除-删除-删除-删除----------delete_onestudent_user---------idStr="+idStr);	
        if(idStr !=null&& !idStr.equals("")) {
        	int idid=Integer.valueOf(idStr);       
	
		Student_UserService service = new Student_UserService();
		// 2.调用service层用于查询所有商品的方法
		int reid = service.delete_onestudent_user(idid);
		if(reid!=0) {
			 PrintWriter pw = response.getWriter();	     
		 	
		 	pw.print("<script language=javascript>alert(`删除选中用户信息成功`);window.location.href=`Student_userServlet?method=1`</script>");
		  	
		}
	}
	}

	private void add_onestudent_user(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String unique=request.getParameter("unique_id");
		System.out.println("============="+unique);
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String msex=request.getParameter("msex");
		String idcard=request.getParameter("idcard");
		String phonenumber=request.getParameter("phonenumber");
		System.out.println("phonenumber"+phonenumber);
		System.out.println(msex);	
		System.out.println("-----Student_userServlet--add_onestudent_user()---"
				+ "--unique---password"+unique+"---"+password);		
		Student_UserService service = new Student_UserService();
	 	 PrintWriter pw = response.getWriter();
		// 2.调用service层用于查询所有商品的方法
		if(name==null||password==null||name==""||password==""||msex==null) {
			
	pw.print("<script language=javascript>alert(`添加信息失败，请重新填写`);window.location.href=`add_onestudent.jsp`</script>");
			
		}else {
    	student_User su=new student_User();   
    	su.setUnique_id(unique);
    	su.setName(name);
    	su.setPassword(password);
    	su.setSex(msex);
    	su.setIdcard_number(idcard);
    	su.setPhonenumber(phonenumber);
    	Boolean flag = service.add_onestudent_user(su);

		//pw.write("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;注  &nbsp;&nbsp;册   &nbsp;成  &nbsp;功"
			//	+ "&nbsp;现&nbsp;在&nbsp;可&nbsp;以&nbsp;登&nbsp;陆&nbsp;啦           ");
		//response.setHeader("Refresh", "2;URL=/StyleMall/login.jsp");
		pw.print("<script language=javascript>alert(`添加用户成功`);window.location.href=`Student_userServlet?method=1`</script>");
	}
}
	
	
	private void copyonestudent_user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter( "id" );
        if(idStr !=null&& !idStr.equals("")) {
        	int idid=Integer.valueOf(idStr);       
	
		System.out.println("---------Student_userServlet--------id="+idid);
		Student_UserService service = new Student_UserService();
		// 2.调用service层用于查询所有商品的方法
		student_User onestudent = service.copyonestudent_user(idid);
		System.out.println("---------Student_userServlet--------onestudent="+onestudent);
		//HttpSession session=request.getSession();
		//session.setAttribute("onestudent", onestudent);
		
		request.setAttribute("onestudent", onestudent);
		// 4.重定向到list.jsp页面
		
		request.getRequestDispatcher("/update_onestudent.jsp").forward(
		request, response);
		
	}
	}

	private void realupdate_onestudent_user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter( "upid" );
		
		String unique=request.getParameter("unique_id");
		System.out.println("============="+unique);
		
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		String msex=request.getParameter("msex");
		System.out.println(msex);
		String idcard=request.getParameter("idcard");
		String phonenumber=request.getParameter("phonenumber");
		System.out.println("-----Student_userServlet--realupdate_onestudent_user()---"
				+ "--unique+password"+unique+password);		
        if(idStr !=null&& !idStr.equals("")) {
        	int idid=Integer.valueOf(idStr);    
        	Student_UserService service = new Student_UserService();
    		// 2.调用service层用于查询所有商品的方法
        	student_User su=new student_User();
        	su.setId(idid);
        	su.setUnique_id(unique);
        	su.setName(name);
        	su.setPassword(password);
        	su.setSex(msex);
        	su.setIdcard_number(idcard);
        	su.setPhonenumber(phonenumber);
        	student_User onestudent = service.realupdate_onestudent_user(su);
    		System.out.println("---------Student_userServlet-----"
    				+ "--Boolean onestudent="+onestudent.getId());
    		System.out.println("-----执行--Student_userServlet---su.getId()="+su.getId());

    		student_User afterupdate = service.afterupdate_realupdate_onestudent_user(idid);
    	   	System.out.println("-----执行--Student_userServlet---afterupdate.getphonenumber()="+afterupdate.getPhonenumber());
       	 PrintWriter pw = response.getWriter();
       	HttpSession session=request.getSession();
		session.setAttribute("afterupdate", afterupdate);
       	 pw.print("<script language=javascript>alert(`修改选中用户信息成功 `);</script>");
       	response.setHeader("Refresh", "1;URL=/MiddleSchoolWebsite/afterupdate_onestudent.jsp");
       	System.out.println("-----执行--Student_userServlet---sid=idid="+idid);
       	//request.setAttribute("onestudent", afterupdate);
		//request.getRequestDispatcher("/update_onestudent.jsp").forward(
		//		request, response);
        }
        
	}
	
	
	
	
	private void update_onestudent_user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter( "id" );
        if(idStr !=null&& !idStr.equals("")) {
        	int idid=Integer.valueOf(idStr);       
	
		System.out.println("---------Student_userServlet--------id="+idid);
		Student_UserService service = new Student_UserService();
		// 2.调用service层用于查询所有商品的方法
		List<student_User> onestudent = service.update_onestudent_user(idid);
		request.setAttribute("onestudent", onestudent);
		// 4.重定向到list.jsp页面
		//request.getRequestDispatcher("/update_onestudent.jsp").forward(
		//		request, response);
		request.getRequestDispatcher("/lookonestudent.jsp").forward(
				request, response);
	}
	}
	private void listall_user(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		// TODO Auto-generated method stub
		// ArrayList<student_User> allusers=(ArrayList<student_User>)Student_Userdao.getInstance().listallstudent_users();
		// 1.创建service层的对象
		Student_UserService service = new Student_UserService();
				// 2.调用service层用于查询所有商品的方法
				List<student_User> sus = service.listallstudent_users();
				//分页
				if(sus==null) {
					sus=new ArrayList<student_User>();
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
				request.getRequestDispatcher("/student_admin.jsp").forward(
						request, response);
				
	
	}

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}