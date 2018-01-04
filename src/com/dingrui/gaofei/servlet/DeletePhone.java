package com.dingrui.gaofei.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dingrui.gaofei.dao.UserDAO;


public class DeletePhone extends HttpServlet
{
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

		response.setContentType("text/html;charset=gbk");
		PrintWriter out = response.getWriter();
		
		int id = Integer.parseInt(request.getParameter("man_id"));
		
		//����UserDAO�е�ɾ���û��ķ���
		if(new UserDAO().deletePhone(id))
		{
			//ɾ���ɹ�
			response.sendRedirect("ok");
		}
		else
		{
			//ɾ��ʧ��
			response.sendRedirect("error");
		}
			
		
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException
	{

	}

}
