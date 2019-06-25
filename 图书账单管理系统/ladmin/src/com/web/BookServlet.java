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
import javax.websocket.Decoder.Text;

import com.dao.BooksDao;
import com.domain.Book;

/**
 * Servlet implementation class BookServlet
 */
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookServlet() {
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
		
		
		System.out.println("method="+method);
		
	
		switch (method) {
		case 0:{
			this.selectall_books(request,response);
			break;
		}
		 
		
        case 1:{
        	this.selectone_books(request,response);
			break;
		}
		
        case 2:{
        	this.update_books(request,response);
			break;
		}
        case 3:{
        	this.deleteone_books(request,response);
			break;
		}
        
        case 4:{
        	this.insertone_books(request,response);
			break;
		}
        
        case 5:{
        	this.searchone_books(request,response);
			break;
		}
        
        
		default:
			break;
		}
	}

	
	
	
	

	private void searchone_books(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String bookname = request.getParameter("bookname");		
		Book book=new Book();
		book.setBookname(bookname);		
		 ArrayList<Book> bookstore=BooksDao.getInstance().searchbooks(book);
	
		 if(bookstore==null) {
				bookstore=new ArrayList<Book>();
			}
			int recordCount=bookstore.size();//记录条数
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
			session.setAttribute("bs", bookstore);
			request.setAttribute("bookstore", bookstore);
			
		RequestDispatcher rd=request.getRequestDispatcher("billist.jsp");
		rd.forward(request, response);
		 
		
	}

	private void insertone_books(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String bookid = request.getParameter("bookid");
		String bookname = request.getParameter("bookname");
		String author = request.getParameter("author");
		String print = request.getParameter("print");
		String price = request.getParameter("price");
		String tip = request.getParameter("tip");
		Book book=new Book();
		PrintWriter pw = response.getWriter();
		if(!bookid.isEmpty()||!bookname.isEmpty()||!author.isEmpty()) {
			book.setBookid(bookid);
			book.setBookname(bookname);
			book.setAuthor(author);
			book.setPrint(print);
			book.setPrice(price);
			book.setTip(tip);	
			int rcount=BooksDao.getInstance().insertbooks(book);
			
			if (rcount!=0) {
				
				pw.print("<script language=javascript>alert(`添加书籍成功 `);window.location.href=`BookServlet?method=0`</script>");
				
			//pw.write("&nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp;  添&nbsp;加&nbsp;成&nbsp;功         ");
			//response.setHeader("Refresh", "2;URL=/ladmin/BookServlet?method=0");
			}
			
		}else {
			pw.print("<script language=javascript>alert(`信息有误，添加失败，请重新填写`);window.location.href=`billAdd.jsp`</script>");
		}
		
		
		
		
	
		
	}

	private void deleteone_books(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		PrintWriter pw = response.getWriter();
		String idStr = request.getParameter( "id" );
        if(idStr !=null&& !idStr.equals("")) {
        	int id=Integer.valueOf(idStr); 
        
		System.out.println("id="+id);
	   
	int rid=BooksDao.getInstance().deleteone_books(id);
	
	if(rid!=0) {
		pw.print("<script language=javascript>alert(`删除选中用户成功 `);window.location.href=`BookServlet?method=0`</script>");
		
			
	}
	
        }else {
        	
        	pw.write("&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;  删&nbsp;除&nbsp;失&nbsp;败 ");
  			response.setHeader("Refresh", "2;URL=/ladmin/BookServlet?method=0");
		}
	}

	private String selectone_books(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		
		String idStr = request.getParameter( "id" );
        if(idStr !=null&& !idStr.equals("")) {
        	int id=Integer.valueOf(idStr); 
        
		
		
		System.out.println("id="+id);
	   
	   
		Book book=BooksDao.getInstance().selectonebooks(id);
		
		 
		     System.out.println("bookservlet的book.getId()="+book.getId());
		     System.out.println("bookservlet的 book.getBookid()="+ book.getBookid());
		while(book!=null) {
			
		
		request.setAttribute("rbook",book);
		RequestDispatcher rd=request.getRequestDispatcher("billUpdate.jsp");
		rd.forward(request, response);
		}
		
        }
		else {
			
			  System.out.println("bookservlet查询当前id结果失败");
			
		}
		return null;
		
		
	}

	private void update_books(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idStr = request.getParameter( "id" );
		String bookid = request.getParameter("bookid");
		String bookname = request.getParameter("bookname");
		String author = request.getParameter("author");
		String print = request.getParameter("print");
		String price = request.getParameter("price");
		String tip = request.getParameter("tip");

        if(idStr !=null&& !idStr.equals("")) {
        	int id=Integer.valueOf(idStr); 
        	Book book=new Book();
        	book.setId(id);
    		book.setBookid(bookid);
    		book.setBookname(bookname);
    		book.setAuthor(author);
    		book.setPrint(print);
    		book.setPrice(price);
    		book.setTip(tip);
    		
    		 System.out.println("bookservlet修改的book.getBookname()="+book.getBookname());
			 System.out.println("bookservlet修改的book.getAuthor()="+book.getAuthor());
        Book rc=BooksDao.getInstance().updateone_books(book);
        
       
        	 System.out.println("成功");
        	
        	
        	 PrintWriter pw = response.getWriter();
        	 pw.print("<script language=javascript>alert(`修改选中书籍成功 `);window.location.href=`BookServlet?method=0`</script>");
          	
         	
 			 System.out.println("成功");
        	
       
        
        }else {
        	
        	 System.out.println("修改失败");
        	RequestDispatcher rd=request.getRequestDispatcher("update.jsp");
    		rd.forward(request, response);	
        }
       
        
	}

	private void selectall_books(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 ArrayList<Book> bookstore=BooksDao.getInstance().selectallbooks();
			
			if(bookstore==null) {
				bookstore=new ArrayList<Book>();
			}
			int recordCount=bookstore.size();//记录条数
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
			session.setAttribute("bookstore", bookstore);
			request.setAttribute("bksr", bookstore);
			
		RequestDispatcher rd=request.getRequestDispatcher("billist.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
