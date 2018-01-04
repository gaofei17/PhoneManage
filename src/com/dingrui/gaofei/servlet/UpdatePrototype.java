package com.dingrui.gaofei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dingrui.gaofei.bean.Manage;
import com.dingrui.gaofei.dao.ManageDAO;
import com.dingrui.gaofei.dao.UserDAO;

public class UpdatePrototype extends HttpServlet{

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
				
				HttpSession session=req.getSession();
				
		        String pass =(String) session.getAttribute("username");
				
				if(pass == null){
					resp.sendRedirect("login");
				}
				
				
				 out.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'> ");
				 out.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
				 out.println("<head><meta http-equiv='Content-Type' content='text/html; charset=gb2312' />");
				 out.println("<title>�༭״̬</title>");
				 out.println("<link href='./edit.css' rel='stylesheet' type='text/css'>");
				 out.println("</head>");
				 out.println("<center><body>");
				 out.println("<div id='container'></div>");
				 out.println("<div id='Header'></div>");
				 out.println("<div id='PageBody'>");	
				 out.println("<h1>�޸�������</h1>");
				out.println("<form action=updateprototypecl method=get target=new>");
				
				out.println("<table border=1>");
				//disabled='disabled'����������Ժ󣬷�������ȡ����ֵ 
				out.println("<tr>" +
						"<td>ID:</td>" +
						"<td><input readonly type=text name=Bor_id value="+req.getParameter("man_id")+" size=60 ></td>" +
						"</tr>");
				
				out.println("<tr>" +
						"<td>����:</td>" +
						"<td><input type=text name=Pro_board value="+req.getParameter("man_board")+" size=60 ></td>" +
						"</tr>");


				out.println("<tr>" +
						"<td>�ͻ�:</td>" +
						"<td><input type=text name=Pro_client value="+req.getParameter("man_client")+" size=60 ></td>" +
						"</tr>");

				
				out.println("<tr>" +
						"<td>�ͺ�:</td>" +
						"<td><input type=text name=Pro_model value="+req.getParameter("man_model")+" size=60 ></td>" +
						"</tr>");
				
				out.println("<tr>" +
						"<td>BOM:</td>" +
						"<td><input  type=text name=Pro_bom value="+req.getParameter("man_bom")+" size=60 ></td>" +
						"</tr>");
				out.println("<tr>" +
						"<td>FLASH:</td>" +
						"<td><input type=text name=Pro_flash value="+req.getParameter("man_flash")+" size=60 ></td>" +
						"</tr>");
				out.println("<tr>" +
						"<td>CAM:</td>" +
						"<td><input type=text name=Pro_cam value="+req.getParameter("man_cam")+" size=60 ></td>" +
						"</tr>");
				out.println("<tr>" +
						"<td>LCM:</td>" +
						"<td><input type=text name=Pro_lcm value="+req.getParameter("man_lcm")+" size=60 ></td>" +
						"</tr>");
				out.println("<tr>" +
						"<td>����:</td>" +
						"<td><input type=text name=Pro_amou value="+req.getParameter("man_amou")+" size=60 ></td>" +
						"</tr>");
				out.println("<tr>" +
						"<td>��ע:</td>" +
						"<td><input  type=text name=Pro_rem value="+req.getParameter("man_rem")+" size=60 ></td>" +
						"</tr>");
				out.println("<tr>" +
						"<td>�������:</td>" +
						"<td> <input name=Bor_number value="+req.getParameter("man_number")+"  size=60 ></td>" +
						"</tr>");
				
				//��֮ǰ�����˴�ӡ���֣������ϲ�����ʾ�������ۼ�����
				out.println("<tr>" +
						"<td>��һ������:</td>" +
						"<td> <input style='display:none' name=Old_user value="+req.getParameter("man_user")+"  size=60 ></td>" +
						"</tr>");//��֮ǰ�����˴�ӡ���֣������ϲ�����ʾ�������ۼ�����
				
				ManageDAO dao = new ManageDAO();
				 List<Manage> searchrsu = dao.getSearchDatau();
				  out.println("<tr><td><font size='6' color='red'>�����ˣ�</font></td><td><select name=Bor_user>");
				  out.println("<option value =''>�黹</option>");
				  for(int i = 0;i<searchrsu.size();i++){
		        	  Manage man = searchrsu.get(i);	
				  out.println("<option value ="+man.getMan_user()+">"+man.getMan_user()+"</option>");
	                }
				  
				/**out.println("<tr><td><font size='6' color='red'>�����ˣ�</font></td><td><select name=Bor_user>");
				out.println("<option value =''></option>");
				out.println("<option value ='tang_s'>��˼</option>");
				out.println("<option value ='dong_lh'>���ֻ�</option>");
				out.println("<option value ='long_yl'>������</option>");
				out.println("<option value ='deng_xk'>��С��</option>");
				out.println("<option value ='peng_yx'>������</option>");
				out.println("<option value ='cheng_wq'>����ǿ</option>");
				out.println("<option value ='ou_cl'>ŷ����</option>");
				out.println("<option value ='long_y'>����</option>");
				out.println("<option value ='peng_h'>��</option>");
				out.println("<option value ='zhang_y'>����</option>");
				out.println("<option value ='li_sh'>������</option>");
				out.println("<option value ='yi_f'>�׷�</option>");
				out.println("<option value ='li_cx'>���ϼ</option>");
				out.println("<option value ='zhong_t'>����</option>");
				out.println("<option value ='luo_yr'>������</option>");
				out.println("<option value ='jia_h'>�ֻ�</option>");**/
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
