package com.dingrui.gaofei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class AdminSearchWelCl extends HttpServlet{

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
		
		//1.得到session
		HttpSession hs = req.getSession(true);
		//修改session的存在时间
		hs.setMaxInactiveInterval(60*60);//秒
		
		//session中保存了2个属性 /uname/pwd
		hs.setAttribute("pro_board", a);
		hs.setAttribute("pro_client", b);
		hs.setAttribute("pro_model", c);
		hs.setAttribute("pro_user", d);
		
		resp.sendRedirect("adminsearchwel");
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
