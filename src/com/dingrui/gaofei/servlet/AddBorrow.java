package com.dingrui.gaofei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AddBorrow extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	      
			// req :��ÿͻ���(�����)����Ϣ

					// res����ͻ��˷�����Ϣ

					// ��������
					resp.setContentType("text/html;charset=gbk");
					req.setCharacterEncoding("GBk");

					PrintWriter out = resp.getWriter();
                     

	                 //��ֹ�Ƿ���¼
					HttpSession session=req.getSession();
					
			        String pass =(String) session.getAttribute("username");
					
					if(pass == null){
						resp.sendRedirect("login");
					}
System.out.println("borrowuser="+req.getParameter("Bro_user"));
					
					out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'> ");
					out.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
					out.println("<head><meta http-equiv='Content-Type' content='text/html; charset=gb2312' />");
					out.println("<title>��������</title>");
					out.println("<link href='./edit.css' rel='stylesheet' type='text/css'>");
					out.println("</head>");
					out.println("<center><body>");
					out.println("<div id='container'></div>");
					out.println("<div id='Header'>");
					out.println("</div>");
					out.println("<div id='PageBody'>");
					
					out.println("<h1>��������</h1>");
					out.println("<form action=addborrowcl method=get target=new>");
					
					out.println("<table border=1>");
					
					out.println("<tr>" +
							"<td>����:</td>" +
							"<td><input type=text name=Pro_board ></td>" +
							"</tr>");


					out.println("<tr>" +
							"<td>�ͻ�:</td>" +
							"<td><input type=text name=Pro_client ></td>" +
							"</tr>");

					
					out.println("<tr>" +
							"<td>�ͺ�:</td>" +
							"<td><input type=text name=Pro_model ></td>" +
							"</tr>");
					
					out.println("<tr>" +
							"<td>BOM:</td>" +
							"<td><input type=text name=Pro_bom ></td>" +
							"</tr>");
					out.println("<tr>" +
							"<td>FLASH:</td>" +
							"<td><input type=text name=Pro_flash ></td>" +
							"</tr>");
					out.println("<tr>" +
							"<td>CAM:</td>" +
							"<td><input type=text name=Pro_cam ></td>" +
							"</tr>");
					out.println("<tr>" +
							"<td>LCM:</td>" +
							"<td><input type=text name=Pro_lcm ></td>" +
							"</tr>");
					
					//������ֶ�
					out.println("<tr>" +
							"<td>TP:</td>" +
							"<td><input type=text name=Pro_tpinfo ></td>" +
							"</tr>");
					out.println("<tr>" +
							"<td>ƽ̨:</td>" +
							"<td><input type=text name=Pro_chipinfo ></td>" +
							"</tr>");
					out.println("<tr>" +
							"<td>�ն�:</td>" +
							"<td><input type=text name=Pro_efuse ></td>" +
							"</tr>");
					out.println("<tr>" +
							"<td>Ƶ��:</td>" +
							"<td><input type=text name=Pro_band ></td>" +
							"</tr>");
					out.println("<tr>" +
							"<td>�յ�����:</td>" +
							"<td><input type=text name=Pro_regdate ></td>" +
							"</tr>");
					
					//
					out.println("<tr>" +
							"<td>����:</td>" +
							"<td><input type=text name=Pro_amou ></td>" +
							"</tr>");
					out.println("<tr>" +
							"<td>��ע:</td>" +
							"<td><input type=text name=Pro_rem ></td>" +
							"</tr>");
					out.println("<tr>" +
							"<td>�������:</td>" +
							"<td> <input type=text name=Bor_number ></td>" +
							"</tr>");
					out.println("<tr><td><font size='6' color='red'>�����ˣ�</font></td><td><select name=Bor_user>");
					out.println("<option value =''>��</option>");
					out.println("</select></td></tr> ");
					
					out.println("<tr><td align=center colspan=2><input type=submit value=ȷ��></td></tr>");
					out.println("</table>");
					
					out.println("</form>");
					out.println("<hr></center></body>");
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
