package com.dingrui.gaofei.servlet;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//req :可以简单的理解为用于得到信息的对象,至于从哪里得到
				//就要看参数名称
				
				//res:可以简单的理解为用户发送信息的对象,要发送那肯定要有对象来设定信息
				//可以是session,cookie

				//解决中文乱码问题方式之一
				resp.setContentType("text/html;charset=gbk");
				
				//从内存中写出信息,然用户看的到。
				PrintWriter out = resp.getWriter();
				
				out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
			    out.println("<html xmlns='http://www.w3.org/1999/xhtml'> ");
			    out.println("<head><meta http-equiv='Content-Type' content='text/html; charset=gb2312' />");
			    out.println("<title>用户登录</title>");
			    out.println("<link href='./css.css' rel='stylesheet' type='text/css'></head>");
			    out.println("<body>");
			    out.println("<div id='container'></div>");
			    out.println("<div id='Header'></div>");
			    out.println("<div id='PageBody'>");
			    out.println("<form action=logincl  method=GET><br><br><br><br><br><br>");
			    out.println("<table align=center width='350' bgcolor='#C0C0C0' style='border-color' border='1'>");
			    out.println("<tr align=center>");
			    out.println("<td>用户名</td><td><input type=text  name=username></td></tr>");
			    out.println("<tr align=center><td>密 码</td><td><input type=password name=passwrod></td></tr>");
			    out.println("<tr align=center><td colspan='2'><input type=submit  value='登录'/> ");
			    out.println("<input type='reset' value='重 置'/></td></tr>");
			    out.println("</table>");
			    out.println(" </form></div>");
			    out.println("<div id='Footer'></div>");
			    out.println("</body>");
			    out.println("</html>");
				out.flush();
				out.close();

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
		
	}

}
