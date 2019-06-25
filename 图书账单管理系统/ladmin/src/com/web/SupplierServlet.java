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
import com.dao.SuppliersDao;
import com.domain.Book;
import com.domain.Supplier;

/**
 * Servlet implementation class BookServlet
 */
public class SupplierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SupplierServlet() {
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
			this.selectall_suppliers(request,response);
			break;
		}
		 
	   
		default:
			break;
		}
	}

	
	private void selectall_suppliers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 ArrayList<Supplier> suppliers=SuppliersDao.getInstance().selectallSuppliers();
			
			if(suppliers==null) {
				suppliers=new ArrayList<Supplier>();
			}
			int recordCount=suppliers.size();//记录条数
			int maxPage=recordCount;//页数
			int number;   //第几页
			if(maxPage%6==0) {
				maxPage=maxPage/6;
			}else {
				maxPage=maxPage/6+1;
			}
			
			if(request.getParameter("i")==null) {
				number=1;
			}else {
				number=Integer.parseInt(request.getParameter("i"));
			}
			
			int start=(number-1)*6;
			int over=number*6-1;
			if(recordCount<=over) {
				over=recordCount;	
			}
			request.setAttribute("start", start);
			request.setAttribute("over", over);
			request.setAttribute("number", number);
			request.setAttribute("maxPage", maxPage);
			request.setAttribute("recordCount", recordCount);
			
			HttpSession session=request.getSession();
			session.setAttribute("suppliers", suppliers);
			request.setAttribute("suppliers", suppliers);
			
		RequestDispatcher rd=request.getRequestDispatcher("supplierList.jsp");
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
