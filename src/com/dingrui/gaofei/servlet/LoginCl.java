package com.dingrui.gaofei.servlet;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.dingrui.gaofei.bean.User;
import com.dingrui.gaofei.dao.UserDAO;

public class LoginCl extends HttpServlet{
	
	//��дinit����
		/**
		 * ��ȡ���Ѵ����ļ��е���Ϣ��ȡ���ڴ���
		 * д�������ڴ��е���Ϣд���������ļ���
		 */
		public void init()
		{
			try
			{
				FileReader fr = new FileReader("D:\\save.txt");
				
				//����һ�����ڴ����ļ��ж�ȡ��Ϣ�Ķ���
				BufferedReader br = new BufferedReader(fr);
				
				//�Ѵ����ļ��е���Ϣ��ȡ���ڴ���
				String numVal = br.readLine();
				
				br.close();

				//times �����������û����ʵ�
				//��timesֵ�ŵ�servletcontent
				//servletcontent:�ڷ�������,���е�¼�����û�������ڴ�ռ�
				//��init()����,��tomcat�������������,ֻ������һ��
				//�Ѵ��ļ��ж�ȡ����ֵ,��visitTimes��ʶ,�ŵ�serveltContex�ڴ���,
				//�ڳ��ε���LoginCLʱִ��һ��,�ڶ��ε���LoinCLʱ��������
				this.getServletContext().setAttribute("visitTimes", 0);
				
				System.out.println("init ������");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		//��дdestroy����,�ر�tomcat�Ǳ�ִ��һ��
		public void destroy()
		{
			try
			{
				//���ڴ��е���Ϣд�ص��ļ���
				FileWriter fw = new FileWriter("D:\\save.txt");
				
				//����һ���ܰ��ڴ��е���Ϣд�ص��ļ��еĶ���
				BufferedWriter bw = new BufferedWriter(fw);
				
				//���ļ���д��һ������,��д�����ʲô��Ϣ��
				//д�����servletContext�ڴ��е���visitTiems��ʶ����Ϣ
				bw.write(this.getServletContext().getAttribute("visitTimes").toString());
				
				bw.close();
				
				System.out.println("destroy ������");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//�õ�Login �û���������
		String username= req.getParameter("username").trim();
		String userpasswd =req.getParameter("passwrod").trim();
		
		UserDAO  ptdo = new UserDAO();
	
		User ur = new User();
		ur.setUser_name(username);
		ur.setUser_passwd(userpasswd);
System.out.println(username+"+"+userpasswd+"+"+ptdo.checkUser(ur));
		
		//�жϵ�¼�û��Ƿ�Ϸ�
		if(ptdo.checkUser(ur)){
			//ÿ���L����������doGet
	        //1.��servletContext�Ы@��visitTimes
	        ServletContext context = getServletContext();
	        int times = (Integer) context.getAttribute("visitTimes");
	        //2.��visitTimes++
	        times++;
	        //3.����
	        context.setAttribute("visitTimes", times);
System.out.println("�Wվ���L����һ�Σ�");
			
			switch(ptdo.checkGrade(ur)){
			case 1:
				//1.�õ�session
				HttpSession hs = req.getSession(true);
				//�޸�session�Ĵ���ʱ��
				hs.setMaxInactiveInterval(60*10);//��
				
				//session�б�����2������ /uname/pwd
				hs.setAttribute("username", username);
				//hs.setAttribute("pass", "ok");
				//hs.setAttribute("userpasswd", userpasswd);
				resp.sendRedirect("welcome");
				//resp.sendRedirect("welcome?boruser="+username);
				
				break;
			case 2:
				//1.�õ�session
				HttpSession hs1 = req.getSession(true);
				//�޸�session�Ĵ���ʱ��
				hs1.setMaxInactiveInterval(60*10);//��
				hs1.setAttribute("username", username);
				resp.sendRedirect("showresult");
				
				break;
			}
			
		}else{
			resp.sendRedirect("login");
System.out.println("fsfdsfdsfs");
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doGet(req, resp);
	}

}
