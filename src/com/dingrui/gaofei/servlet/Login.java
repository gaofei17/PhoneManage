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
		//req :���Լ򵥵����Ϊ���ڵõ���Ϣ�Ķ���,���ڴ�����õ�
				//��Ҫ����������
				
				//res:���Լ򵥵����Ϊ�û�������Ϣ�Ķ���,Ҫ�����ǿ϶�Ҫ�ж������趨��Ϣ
				//������session,cookie

				//��������������ⷽʽ֮һ
				resp.setContentType("text/html;charset=gbk");
				
				//���ڴ���д����Ϣ,Ȼ�û����ĵ���
				PrintWriter out = resp.getWriter();
				
				out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'>");
			    out.println("<html xmlns='http://www.w3.org/1999/xhtml'> ");
			    out.println("<head><meta http-equiv='Content-Type' content='text/html; charset=gb2312' />");
			    out.println("<title>�û���¼</title>");
			    out.println("<link href='./css.css' rel='stylesheet' type='text/css'></head>");
			    out.println("<body>");
			    out.println("<div id='container'></div>");
			    out.println("<div id='Header'></div>");
			    out.println("<div id='PageBody'>");
			    out.println("<form action=logincl  method=GET><br><br><br><br><br><br>");
			    out.println("<table align=center width='350' bgcolor='#C0C0C0' style='border-color' border='1'>");
			    out.println("<tr align=center>");
			    out.println("<td>�û���</td><td><input type=text  name=username></td></tr>");
			    out.println("<tr align=center><td>�� ��</td><td><input type=password name=passwrod></td></tr>");
			    out.println("<tr align=center><td colspan='2'><input type=submit  value='��¼'/> ");
			    out.println("<input type='reset' value='�� ��'/></td></tr>");
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
