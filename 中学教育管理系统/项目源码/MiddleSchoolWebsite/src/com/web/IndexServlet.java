package com.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.Newsinfofaba_dao;
import com.domain.NewsInfofabu;

/**
 * Servlet implementation class IndexServlet
 */
public class IndexServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("这是index方法");
		Newsinfofaba_dao newimagesdao = new Newsinfofaba_dao();
		NewsInfofabu newsfabuget=newimagesdao.getnewsfrom_table();
		HttpSession session=request.getSession();
				session.setAttribute("newsfabuget", newsfabuget);
		request.getRequestDispatcher("index.jsp").forward(request, response);	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
