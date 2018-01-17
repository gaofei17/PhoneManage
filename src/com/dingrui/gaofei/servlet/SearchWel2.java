package com.dingrui.gaofei.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dingrui.gaofei.bean.Manage;
import com.dingrui.gaofei.dao.ManageDAO;

public class SearchWel2 extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		resp.setContentType("text/html;charset=gbk");
		req.setCharacterEncoding("GBk");
		PrintWriter pw = resp.getWriter();
			
		//��ֹ�Ƿ���¼
		HttpSession session=req.getSession();//�����뵱ǰrequest�������session�����û�����ڷ������˴���һ��;
		/**String boruname =(String) session.getAttribute("username");
		if(boruname == null){
			resp.sendRedirect("login");
		}**/
		
		String prob =(String) session.getAttribute("pro_board2");
		String proc =(String) session.getAttribute("pro_client2");
		String prom =(String) session.getAttribute("pro_model2");
		String prou=(String) session.getAttribute("pro_user2");
System.out.println(prob+proc+prom+prou);
		ManageDAO dao = new ManageDAO();
		/*��ҳ����*/
		int pageSize = 22; //ÿҳ��ʾ������
		int pageNow = 1;//�û�ѡ���ҳ
		int rowCount = 0;//�ܹ����������ӱ��в�ѯ�õ���
		int pageCount = 0;//�ж���ҳ�����������
		
		rowCount = dao.search2Count(prob,proc,prom,prou);
		
		//����pagecountֵ
		if(rowCount%pageSize == 0){
			pageCount = rowCount/pageSize;
		}else{
			pageCount = rowCount/pageSize+1;
		} 
		
		//��̬����pageNow
		String sPageNow = req.getParameter("pageNow");
		if(sPageNow != null){
			pageNow=Integer.parseInt(sPageNow);
		}
		
		
		 List<Manage> all=dao.getSearchWel2Data(prob,proc,prom,prou, pageNow, pageSize);
		    pw.println("<!DOCTYPE html PUBLIC '-//W3C//DTD XHTML 1.0 Transitional//EN' 'http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd'> ");
			pw.println("<html xmlns='http://www.w3.org/1999/xhtml'>");
			pw.println("<head><meta http-equiv='Content-Type' content='text/html; charset=gb2312' />");
		    pw.println("<title>������ѯ���</title>");
		    pw.println("<link href='./edit.css' rel='stylesheet' type='text/css'>");
		    
		  //�����ⲿcss��ʽ
		    pw.println("<style type='text/css'>");
		    pw.println("@import 'mytable.css';");
		    pw.println("</style>");
		    
		    pw.println("</head>");
			pw.println("<center><body>");
			pw.println("<div id='container'>");
			//pw.println("<a class=abc style='float:right' href=login >�˳�</a>");
		    pw.println("</div>");
			pw.println("<div id='Header'>");
		    pw.println("</div>");
		    pw.println("<div id='PageBody'>");
		    
		  //����table��ʽmytable
			pw.println("<table  width='1600px' border =0 class=mytable>");
			//pw.println("<table border =1 class=tableSty>");
			pw.println("<tr bgcolor=#F0F0F0><th width='3%'>���</th><th width='5%'>����</th><th width='5%'>�ͻ�</th><th width='5%'>�ͺ�</th><th width='2%'>BOM</th><th width='3%'>FLASH</th><th width='8%'>CAM</th><th width='10%'>LCM</th>  <th width='5%'>TP</th><th width='5%'>ƽ̨</th><th width='2%'>�ն�</th><th width='5%'>Ƶ��</th><th width='7%'>�յ�����</th>  <th width='2%'>����</th><th>��ע</th><th width='2%'>���</th><th width='5%'>������</th><th width='7%'>�������</th></tr>");
			//pw.println("<tr bgcolor=F0F0F0><th>���</th><th>����</th><th>�ͻ�</th><th>�ͺ�</th><th>BOM</th><th>FLASH</th><th>CAM</th><th>LCM</th><th>����</th><th>��ע</th><th>�������</th><th>������</th><th>�������</th></tr>");
			
			//����һ����ɫ����
			String[] myCol = {"#E0E0E0","#F0F0F0"};
			for(int i = 0;i<all.size();i++){ 
				
		        Manage man = all.get(i);
				
				pw.println("<tr bgcolor="+myCol[i%2]+">");
				pw.println("<td>"+man.getMan_id()+"</td>");
				pw.println("<td>"+man.getMan_board()+"</td>");
				pw.println("<td>"+man.getMan_client()+"</td>");
				pw.println("<td>"+man.getMan_model()+"</td>");
				pw.println("<td>"+man.getMan_bom()+"</td>");
				pw.println("<td>"+man.getMan_flash()+"</td>");
				pw.println("<td>"+man.getMan_cam()+"</td>");
				
				//�����Ϻ������ʾ��������		
				pw.println("<td>"+"<a title="+man.getMan_lcm()+">"+man.getMan_lcm()+"<a></td>");
               //������ֶ�
				pw.println("<td>"+man.getMan_tpinfo()+"</td>");
				pw.println("<td>"+man.getMan_chipinfo()+"</td>");
				pw.println("<td>"+man.getMan_efuse()+"</td>");
				pw.println("<td>"+man.getMan_band()+"</td>");
				pw.println("<td>"+man.getMan_regdate()+"</td>");
				//pw.println("<td>"+man.getMan_lcm()+"</td>");
				pw.println("<td>"+man.getMan_amou()+"</td>");
				pw.println("<td>"+man.getMan_rem()+"</td>");	
				pw.println("<td>"+man.getMan_number()+'#'+"</td>");
				pw.println("<td>"+man.getMan_user()+"</td>");			
				//��servlet.xml�ļ����URIEncoding="GBK"��Ϊ�˽�� href ��ת�����Ĳ���ʱ�����ն˻�ȡ������������
				//pw.println("<td><a  href=updateprototype?man_id="+man.getMan_id()+"&man_board="+man.getMan_board()+"&man_client="+man.getMan_client()+"&man_model="+man.getMan_model()+"&man_bom="+man.getMan_bom()+"&man_flash="+man.getMan_flash()+"&man_cam="+man.getMan_cam()+"&man_lcm="+man.getMan_lcm()+"&man_amou="+man.getMan_amou()+"&man_rem="+man.getMan_rem()+"&man_number="+man.getMan_number()+"&man_user="+man.getMan_user()+" >�༭</a></td>");
				//pw.println("<td><a  href=?man_id="+man.getMan_id()+"&man_board="+man.getMan_board()+"&man_client="+man.getMan_client()+"&man_model="+man.getMan_model()+"&man_bom="+man.getMan_bom()+"&man_flash="+man.getMan_flash()+"&man_cam="+man.getMan_cam()+"&man_lcm="+man.getMan_lcm()+"&man_amou="+man.getMan_amou()+"&man_rem="+man.getMan_rem()+"&man_number="+man.getMan_number()+"&man_user="+man.getMan_user()+" >ɾ��</a></td>");
				pw.println("<td>"+man.getSubmission()+"</td>");
				pw.println("</tr>");
			}
			pw.println("</table><br><br>");
			
			//��ʾ������
			//��һҳ
			if(pageNow !=1)
			pw.println("<a href=searchwel2?pageNow="+(pageNow-1)+" >��һҳ</a>");
			
			//��ʾ������
			for(int j = 1;j<=pageNow; j ++)
			{
				pw.println("<a href=searchwel2?pageNow="+j+" > "+j+" </a>");
			}
			//��һҳ
			if(pageNow != pageCount)
			pw.println("<a href=searchwel2?pageNow="+(pageNow+1)+" >��һҳ</a><br><br>");
			
			//ָ����ת��ĳҳ,ʵ������һ����
			pw.println("<form action=searchwel2>");
			pw.println("<input type=text name=pageNow size=10>");
			pw.println("<input type=submit value=go>");
			pw.println("</form>");
			pw.println("<br>��ѯ���"+rowCount+"��.վ��ͳ��"+this.getServletContext().getAttribute("visitTimes").toString()+"��<br>");
			//pw.println("<br>��ѯ���:"+rowCount+"��<br>");
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
