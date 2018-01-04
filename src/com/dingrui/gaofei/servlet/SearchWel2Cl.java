package com.dingrui.gaofei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class SearchWel2Cl extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html;charset=gbk");
		req.setCharacterEncoding("GBk");
		PrintWriter pw = resp.getWriter();
		
		String a = req.getParameter("man_board");
		String b = req.getParameter("man_client");
		String c = req.getParameter("man_model");
		String d = req.getParameter("man_user");
		
		//1.�õ�session
		HttpSession hs = req.getSession(true);
		//�޸�session�Ĵ���ʱ��
		hs.setMaxInactiveInterval(60*60);//��
		
		//session�б�����2������ /uname/pwd
		hs.setAttribute("pro_board2", a);
		hs.setAttribute("pro_client2", b);
		hs.setAttribute("pro_model2", c);
		hs.setAttribute("pro_user2", d);
		
		resp.sendRedirect("searchwel2");
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