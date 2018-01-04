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
      
		// req :获得客户端(浏览器)的信息

				// res：向客户端返回信息

				// 中文乱码
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
				 out.println("<title>编辑状态</title>");
				 out.println("<link href='./edit.css' rel='stylesheet' type='text/css'>");
				 out.println("</head>");
				 out.println("<center><body>");
				 out.println("<div id='container'></div>");
				 out.println("<div id='Header'></div>");
				 out.println("<div id='PageBody'>");	
				 out.println("<h1>修改责任人</h1>");
				out.println("<form action=updateprototypecl method=get target=new>");
				
				out.println("<table border=1>");
				//disabled='disabled'设置这个属性后，服务器获取不到值 
				out.println("<tr>" +
						"<td>ID:</td>" +
						"<td><input readonly type=text name=Bor_id value="+req.getParameter("man_id")+" size=60 ></td>" +
						"</tr>");
				
				out.println("<tr>" +
						"<td>主板:</td>" +
						"<td><input type=text name=Pro_board value="+req.getParameter("man_board")+" size=60 ></td>" +
						"</tr>");


				out.println("<tr>" +
						"<td>客户:</td>" +
						"<td><input type=text name=Pro_client value="+req.getParameter("man_client")+" size=60 ></td>" +
						"</tr>");

				
				out.println("<tr>" +
						"<td>型号:</td>" +
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
						"<td>数量:</td>" +
						"<td><input type=text name=Pro_amou value="+req.getParameter("man_amou")+" size=60 ></td>" +
						"</tr>");
				out.println("<tr>" +
						"<td>备注:</td>" +
						"<td><input  type=text name=Pro_rem value="+req.getParameter("man_rem")+" size=60 ></td>" +
						"</tr>");
				out.println("<tr>" +
						"<td>样机编号:</td>" +
						"<td> <input name=Bor_number value="+req.getParameter("man_number")+"  size=60 ></td>" +
						"</tr>");
				
				//把之前责任人打印出现，界面上不做显示，不留痕迹隐藏
				out.println("<tr>" +
						"<td>上一责任人:</td>" +
						"<td> <input style='display:none' name=Old_user value="+req.getParameter("man_user")+"  size=60 ></td>" +
						"</tr>");//把之前责任人打印出现，界面上不做显示，不留痕迹隐藏
				
				ManageDAO dao = new ManageDAO();
				 List<Manage> searchrsu = dao.getSearchDatau();
				  out.println("<tr><td><font size='6' color='red'>责任人：</font></td><td><select name=Bor_user>");
				  out.println("<option value =''>归还</option>");
				  for(int i = 0;i<searchrsu.size();i++){
		        	  Manage man = searchrsu.get(i);	
				  out.println("<option value ="+man.getMan_user()+">"+man.getMan_user()+"</option>");
	                }
				  
				/**out.println("<tr><td><font size='6' color='red'>责任人：</font></td><td><select name=Bor_user>");
				out.println("<option value =''></option>");
				out.println("<option value ='tang_s'>唐思</option>");
				out.println("<option value ='dong_lh'>董林辉</option>");
				out.println("<option value ='long_yl'>龙燕良</option>");
				out.println("<option value ='deng_xk'>邓小康</option>");
				out.println("<option value ='peng_yx'>彭艺星</option>");
				out.println("<option value ='cheng_wq'>成文强</option>");
				out.println("<option value ='ou_cl'>欧春雷</option>");
				out.println("<option value ='long_y'>龙瑶</option>");
				out.println("<option value ='peng_h'>彭海</option>");
				out.println("<option value ='zhang_y'>张运</option>");
				out.println("<option value ='li_sh'>黎绪衡</option>");
				out.println("<option value ='yi_f'>易芳</option>");
				out.println("<option value ='li_cx'>李彩霞</option>");
				out.println("<option value ='zhong_t'>钟婷</option>");
				out.println("<option value ='luo_yr'>罗玉荣</option>");
				out.println("<option value ='jia_h'>贾辉</option>");**/
				out.println("</select></td></tr> ");
				
				out.println("<tr><td align=center colspan=2><input type=submit value=确定></td></tr>");
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
