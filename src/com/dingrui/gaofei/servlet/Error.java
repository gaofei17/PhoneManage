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
		
		
		HttpSession session=req.getSession();//�����뵱ǰrequest�������session�����û�����ڷ������˴���һ��;
		//String boruname =req.getParameter("boruser");
		//��ֹ�Ƿ���¼
		String boruname =(String) session.getAttribute("username");
		if(boruname == null){
			resp.sendRedirect("login");
		}
		    pw.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'> ");
			pw.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
			pw.println("<head><meta http-equiv='Content-Type' content='text/html; charset=gb2312' />");
		    pw.println("<title>����ʧ��</title>");
		    pw.println("<link href='./edit.css' rel='stylesheet' type='text/css'>");
		    pw.println("</head>");
			pw.println("<center><body>");
			pw.println("<div id='container'>" );
			pw.println("</div>");
			pw.println("<div id='Header'>");
			pw.println("<a href=welcome>����</a>");
		    pw.println("</div>");
		    pw.println("<div id='PageBody'>");
		    pw.println("<h1 bgcolor=#CED3FF>���󣡲���ʧ��</h1>");
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
