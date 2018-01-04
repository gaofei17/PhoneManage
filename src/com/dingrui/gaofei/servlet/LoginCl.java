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
	
	//重写init方法
		/**
		 * 读取：把磁盘文件中的信息读取到内存中
		 * 写出：把内存中的信息写出到磁盘文件中
		 */
		public void init()
		{
			try
			{
				FileReader fr = new FileReader("D:\\save.txt");
				
				//创建一个能在磁盘文件中读取信息的对象
				BufferedReader br = new BufferedReader(fr);
				
				//把磁盘文件中的信息读取到内存中
				String numVal = br.readLine();
				
				br.close();

				//times 必须让所有用户访问到
				//将times值放到servletcontent
				//servletcontent:在服务器中,所有登录在线用户共享该内存空间
				//该init()方法,在tomcat不重启的情况下,只被调用一次
				//把从文件中读取到的值,用visitTimes标识,放到serveltContex内存中,
				//在初次调用LoginCL时执行一次,第二次调用LoinCL时不被调用
				this.getServletContext().setAttribute("visitTimes", 0);
				
				System.out.println("init 被调用");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
		
		//重写destroy方法,关闭tomcat是被执行一次
		public void destroy()
		{
			try
			{
				//把内存中的信息写回到文件中
				FileWriter fw = new FileWriter("D:\\save.txt");
				
				//创建一个能把内存中的信息写回到文件中的对象
				BufferedWriter bw = new BufferedWriter(fw);
				
				//向文件中写入一行数据,那写入的是什么信息呢
				//写入的是servletContext内存中的由visitTiems标识的信息
				bw.write(this.getServletContext().getAttribute("visitTimes").toString());
				
				bw.close();
				
				System.out.println("destroy 被调用");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//得到Login 用户名和密码
		String username= req.getParameter("username").trim();
		String userpasswd =req.getParameter("passwrod").trim();
		
		UserDAO  ptdo = new UserDAO();
	
		User ur = new User();
		ur.setUser_name(username);
		ur.setUser_passwd(userpasswd);
System.out.println(username+"+"+userpasswd+"+"+ptdo.checkUser(ur));
		
		//判断登录用户是否合法
		if(ptdo.checkUser(ur)){
			//每次訪問都會執行doGet
	        //1.從servletContext中獲得visitTimes
	        ServletContext context = getServletContext();
	        int times = (Integer) context.getAttribute("visitTimes");
	        //2.將visitTimes++
	        times++;
	        //3.更新
	        context.setAttribute("visitTimes", times);
System.out.println("網站被訪問了一次！");
			
			switch(ptdo.checkGrade(ur)){
			case 1:
				//1.得到session
				HttpSession hs = req.getSession(true);
				//修改session的存在时间
				hs.setMaxInactiveInterval(60*10);//秒
				
				//session中保存了2个属性 /uname/pwd
				hs.setAttribute("username", username);
				//hs.setAttribute("pass", "ok");
				//hs.setAttribute("userpasswd", userpasswd);
				resp.sendRedirect("welcome");
				//resp.sendRedirect("welcome?boruser="+username);
				
				break;
			case 2:
				//1.得到session
				HttpSession hs1 = req.getSession(true);
				//修改session的存在时间
				hs1.setMaxInactiveInterval(60*10);//秒
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
