package com.dingrui.gaofei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Error extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html;charset=gbk");
		req.setCharacterEncoding("GBk");
		PrintWriter pw = resp.getWriter();
		
		
		HttpSession session=req.getSession();//返回与当前request相关联的session，如果没有则在服务器端创建一个;
		//String boruname =req.getParameter("boruser");
		//防止非法登录
		String boruname =(String) session.getAttribute("username");
		if(boruname == null){
			resp.sendRedirect("login");
		}
		    pw.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'> ");
			pw.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
			pw.println("<head><meta http-equiv='Content-Type' content='text/html; charset=gb2312' />");
		    pw.println("<title>操作失败</title>");
		    pw.println("<link href='./edit.css' rel='stylesheet' type='text/css'>");
		    pw.println("</head>");
			pw.println("<center><body>");
			pw.println("<div id='container'>" );
			pw.println("</div>");
			pw.println("<div id='Header'>");
			pw.println("<a href=welcome>返回</a>");
		    pw.println("</div>");
		    pw.println("<div id='PageBody'>");
		    pw.println("<h1 bgcolor=#CED3FF>错误！操作失败</h1>");
			pw.println("</div>");
		    pw.println("<div id='Footer'></div>");	
			pw.println("</body></center>");
			pw.println("</html>");
			pw.flush();
			pw.close();
			
		} 
					

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
